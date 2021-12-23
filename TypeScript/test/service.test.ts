interface Country {
}

interface GeoService {
    isInCommonMarket(country: Country): boolean;

    isInNorthAmerica(country: Country): boolean;

    distanceBetweenInKm(from: Country, to: Country): number;
}

enum DeliveryType {
    Express,
    Standard,
}

class ShippingCostService {
    constructor(private readonly geoService: GeoService) {
    }

    calculateCost(country: Country, deliveryType?: DeliveryType): number {
        if (this.geoService.isInCommonMarket(country)) {
            return 5;
        }

        if (this.geoService.isInNorthAmerica(country)) {
            switch (deliveryType) {
                case DeliveryType.Express:
                    return 50;
                case DeliveryType.Standard:
                    return 35;
            }
        }

        const distanceInKm = this.geoService.distanceBetweenInKm({code: "AT"}, country);
        return distanceInKm * 0.09;
    }
}

describe("Shipping Cost Service", () => {

    function buildGeoServiceStub(commonMarket:boolean = true, inNorthAmerica:boolean = false, distance:number = 0) {
        return {
                   distanceBetweenInKm: (from: Country, to: Country): number => distance,
                   isInNorthAmerica: (country: Country) => inNorthAmerica,
                   isInCommonMarket: (country: Country) => commonMarket,
               };
    }

    it("should return 5 when country in common market", () => {
        const sut = new ShippingCostService(buildGeoServiceStub());

        expect(sut.calculateCost({code: "DE"})).toEqual(5);
    });

    it("should return 50 when country in North America and Delivery Type Express", () => {
        const geoServiceStub: GeoService = {
            distanceBetweenInKm: (from: Country, to: Country): number => 0,
            isInNorthAmerica: (country: Country) => true,
            isInCommonMarket: (country: Country) => false,
        };

        const sut = new ShippingCostService(geoServiceStub);

        expect(sut.calculateCost({code: "US"}, DeliveryType.Express)).toEqual(50);
    });

    it("should return 50 when country in North America and Delivery Type Standard", () => {
        const geoServiceStub: GeoService = {
            distanceBetweenInKm: (from: Country, to: Country): number => 0,
            isInNorthAmerica: (country: Country) => true,
            isInCommonMarket: (country: Country) => false
        };

        const sut = new ShippingCostService(geoServiceStub);

        expect(sut.calculateCost({code: "US"}, DeliveryType.Standard)).toEqual(
            35
        );
    });

    it("should return 90 when country neither in North America nor Common Market", () => {
        const geoServiceStub: GeoService = {
            isInNorthAmerica: (country: Country) => false,
            isInCommonMarket: (country: Country) => false,
            distanceBetweenInKm: (from: Country, to: Country) => 1000
        };

        const sut = new ShippingCostService(geoServiceStub);

        expect(sut.calculateCost({code: "RU"})).toEqual(90);
    });
});

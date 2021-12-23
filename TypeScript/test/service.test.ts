interface Country {}

interface GeoService {
  isInCommonMarket(country: Country): boolean;
  isInNorthAmerica(country: Country): boolean;
}

enum DeliveryType {
  Express,
  Standard,
}

class ShippingCostService {
  constructor(private readonly geoService: GeoService) {}

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

    return -1;
  }
}

describe("Shipping Cost Service", () => {
  it("should return 5 when country in common market", () => {
    let geoServiceStub: GeoService = {
      isInNorthAmerica: (country: Country) => false,
      isInCommonMarket: (country: Country) => true,
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "DE" })).toEqual(5);
  });

  it("should return 50 when country in North America and Delivery Type Express", () => {
    let geoServiceStub: GeoService = {
      isInNorthAmerica: (country: Country) => true,
      isInCommonMarket: (country: Country) => false,
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "US" }, DeliveryType.Express)).toEqual(50);
  });

  it("should return 50 when country in North America and Delivery Type Standard", () => {
    let geoServiceStub: GeoService = {
      isInNorthAmerica: (country: Country) => true,
      isInCommonMarket: (country: Country) => false,
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "US" }, DeliveryType.Standard)).toEqual(
      35
    );
  });
});

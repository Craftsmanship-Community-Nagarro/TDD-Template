interface Country {}

interface GeoService {
  isInCommonMarket(country: Country): boolean;
  isInNorthAmerica(country: Country): boolean;
}

class ShippingCostService {
  constructor(private readonly geoService: GeoService) {}
  calculateCost(country: Country): number {
    const isInCommonMarket = this.geoService.isInCommonMarket(country);
    if (isInCommonMarket) {
      return 5;
    }
    return -1;
  }
}

describe("Shipping Cost Service", () => {
  it("should return 5 when country in common market", () => {
    let geoServiceStub: GeoService = {
      isInNorthAmerica: (country: Country) => false,
      isInCommonMarket: (country: Country) => true
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "DE" })).toEqual(5);
  });

  it("should return 50 when country in North America", () => {
    let geoServiceStub: GeoService = {
      isInNorthAmerica: (country: Country) => true,
      isInCommonMarket: (country: Country) => false
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "US" })).toEqual(50);
  });


});

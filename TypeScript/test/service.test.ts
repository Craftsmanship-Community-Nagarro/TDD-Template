interface Country {}

interface GeoService {
  isInCommonMarket(country: Country): boolean;
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

describe("Shipping Cost", () => {
  it("should return 5 when country in common market", () => {
    let geoServiceStub: GeoService = {
      isInCommonMarket: (country: Country) => true,
    };

    let sut = new ShippingCostService(geoServiceStub);

    expect(sut.calculateCost({ code: "DE" })).toEqual(5);
  });
});

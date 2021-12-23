interface Country {
}

class ShippingCostService {
    calculateCost(country: Country): number {
        return -1;
    }
}

describe("Shipping Cost", () => {

    it("should return 5 when country in common market", () => {
        let sut = new ShippingCostService();

        expect(sut.calculateCost({code: "DE"})).toEqual(5);
    });

});
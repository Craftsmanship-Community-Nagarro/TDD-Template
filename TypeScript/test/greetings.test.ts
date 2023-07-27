import { Game, Rule } from "../app/yahtzeeGame";

it('Should be Yahtzee', () => {
    expect(new Game().score(1,1,1,1,1,Rule.Yahtzee)).toBe(50);
});

it('Shouldn\'t be Yahtzee', () => {
    expect(new Game().score(1,2,3,4,5,Rule.Yahtzee)).toBe(0);
});

it('Should be Yahtzee', () => {
    expect(new Game().score(2,2,2,2,2,Rule.Yahtzee)).toBe(50);
});

/*it('Shouldn\'t be Yahtzee if already scored', () => {
    let game = new Game();
    game.score(2,2,2,2,2,Rule.Yahtzee);
    expect(game.score(2,2,2,2,2,Rule.Yahtzee)).toThrow(TypeError);
});*/

it('throws an error if the version is wrong', () => {
    expect(() => myParser('0.,4')).toThrowWithCause('INVALID_VERSION')
  })
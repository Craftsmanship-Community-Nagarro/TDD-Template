export enum Rule {
    Yahtzee
}

export class Game {
    player:Player;
    constructor() {
        this.player = new Player();
    }
    score = (dieOne:number, dieTwo:number, dieThree:number, dieFour:number, dieFive:number, rule:Rule):number => {
        this.player.removeRule(rule);
        let numberArray: number[] = [dieOne, dieTwo, dieThree, dieFour, dieFive];

        if(this.areDiceValuesEqual(numberArray))
        return 50;
        else
        return 0
    };

    areDiceValuesEqual = (diceValues: number[]): boolean => {
        // Check if all elements in the array are equal to the first element
        return diceValues.every((value) => value === diceValues[0]);
      }


}

export class Player {
    availableRules: Rule[] = [Rule.Yahtzee]

    removeRule = (usedRule: Rule) => {
        if(this.availableRules.includes(usedRule))
        this.availableRules.splice(usedRule);
        else
        throw new TypeError();
    }
    
}
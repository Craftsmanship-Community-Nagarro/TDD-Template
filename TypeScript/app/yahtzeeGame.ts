export enum Rule {
    Yahtzee,
    Sum
}

export class Game {
    player:Player;
    constructor() {
        this.player = new Player();
    }
    score = (dieOne:number, dieTwo:number, dieThree:number, dieFour:number, dieFive:number, rule:Rule):number => {
        this.player.removeRule(rule);
        let numberArray: number[] = [dieOne, dieTwo, dieThree, dieFour, dieFive];

        if(rule === Rule.Yahtzee)
        return this.areDiceValuesEqual(numberArray) ? 50 : 0;
        else if(rule == Rule.Sum)
        return dieOne + dieTwo + dieThree + dieFour + dieFive
        else
        return 0;
    };

    areDiceValuesEqual = (diceValues: number[]): boolean => {
        // Check if all elements in the array are equal to the first element
        return diceValues.every((value) => value === diceValues[0]);
      }


}

export class Player {
    availableRules: Rule[] = [...Object.values(Rule) as Rule[]]

    removeRule = (usedRule: Rule) => {
        if(this.availableRules.includes(usedRule))
        this.availableRules.splice(usedRule);
        else
        throw new TypeError();
    }
    
}
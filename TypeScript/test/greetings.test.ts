import {greetings} from "../app/greetings";


it('should greet', () => {
    expect(greetings()).toBe("Hello World!")
});

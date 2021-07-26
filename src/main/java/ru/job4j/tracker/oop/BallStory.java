package ru.job4j.tracker.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        ball.run();
        hare.tryEat(ball);
        ball.singSong();
        ball.run();
        wolf.tryEat(ball);
        ball.singSong();
        ball.run();
        fox.tryEat(ball);
        ball.singSong();
        fox.deceive(ball);
        fox.eat(ball);
        ball.die();
    }
}

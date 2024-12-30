package com.solid;

public class LiskovsSubstitutionPrinciple {

    public static void main(String[] args) {
        GameManger manger = new GameManger();

        GameUnit infantry = new InfantryGameUnit();
        GameUnit airForce = new AirforceGameUnit();
        GameUnit support = new SupportGameUnit();

        manger.canAttach(infantry);
        manger.canAttach(airForce);
        manger.canAttach(support);

        manger.processMoviment(infantry, 23450, 30000);
        manger.processMoviment(airForce, 4000, 6000);
        manger.processMoviment(support, 3000, 5000);

    }
}

class GameManger {
    public void processMoviment(GameUnit gameUnit, int x, int y) {
        gameUnit.move(x, y);
    }

    public void canAttach(GameUnit gameUnit) {
        if (gameUnit.canAttack()) {
            System.out.println("Attacking ");
        } else {
            System.out.println("Not ready!");
        }
    }
}

class SupportGameUnit extends GameUnit {
    @Override
    public void move(int x, int y) {
        System.out.println("Support is ready when ever needed at x:" + x + "y: " + y);
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}

class AirforceGameUnit extends GameUnit {

    @Override
    public void move(int x, int y) {
        System.out.println("Airforce is not yet ready at x:" + x + "y: " + y);
    }

    @Override
    public boolean canAttack() {
        return false;
    }

}

class InfantryGameUnit extends GameUnit {

    @Override
    public void move(int x, int y) {
        System.out.println("Infantry unit moveing on ground at x:" + x + "y: " + y);
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}

abstract class GameUnit {
    private int health;

    public abstract void move(int x, int y);

    public abstract boolean canAttack();

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

}

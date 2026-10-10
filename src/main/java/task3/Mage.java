package task3;

public class Mage extends Hero {

    private final int maxMana;
    private int mana;

    public Mage(String name, int maxHealth, int baseAttack, int maxMana) {
        super(name, maxHealth, baseAttack);
        if (maxMana < MIN_STAT_VALUE) {
            this.maxMana = MIN_STAT_VALUE;
        } else {
            this.maxMana = maxMana;
        }
        this.mana = this.maxMana;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void attack(Hero target) {
        if (mana >= 10) {
            int damage = getBaseAttack() * 2;
            System.out.println(getName() + " кидает заклинание на " + target.getName() + " урон = " + damage + " мана -10");
            target.takeDamage(damage);
            mana = mana - 10;
        } else {
            int damage = getBaseAttack() / 2;
            System.out.println(getName() + " бьет посохом урон " + damage + " мана +5");
            target.takeDamage(damage);
            mana = mana + 5;
            if (mana > maxMana) {
                mana = maxMana;
            }
        }
    }

    @Override
    public ActionType makeTurn(Hero target) {
        if (canCast()) {
            castSpecialSkill(target);
            return ActionType.SPECIAL_SKILL;
        } else if (needsRest()) {
            rest();
            return ActionType.REST;
        } else {
            attack(target);
            return ActionType.BASE_ATTACK;
        }
    }

    @Override
    public boolean canCast() {
        return mana >= 25;
    }

    @Override
    public void castSpecialSkill(Hero target) {
        if (mana < 25) {
            System.out.println(getName() + " не может кинуть огненную глыбу не хватает маны");
            return;
        }
        int damage = getBaseAttack() * 3;
        System.out.println(getName() + " бросает огненную глыбу в " + target.getName() + " урон " + damage + " мана -25");
        target.takeDamage(damage);
        mana = mana - 25;
    }

    @Override
    public boolean needsRest() {
        if (mana == 0) {
            return true;
        }
        return getHealth() * 100 < getMaxHealth() * 30;
    }

    @Override
    public void rest() {
        mana = maxMana;
        int healAmount = getBaseAttack();
        heal(healAmount);
        System.out.println(getName() + " медитирует мана = " + mana + " хп +" + healAmount);
    }
}

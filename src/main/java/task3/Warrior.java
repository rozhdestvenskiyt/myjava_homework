package task3;

public class Warrior extends Hero {

    private final int armor;

    public Warrior(String name, int maxHealth, int baseAttack, int armor) {
        super(name, maxHealth, baseAttack);
        if (armor < MIN_STAT_VALUE) {
            this.armor = MIN_STAT_VALUE;
        } else {
            this.armor = armor;
        }
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void takeDamage(int damage) {
        int finalDamage = damage - armor;
        if (finalDamage < 1) {
            finalDamage = 1;
        }
        super.takeDamage(finalDamage);
    }

    @Override
    public void attack(Hero target) {
        System.out.println(getName() + " атакует " + target.getName() + " и наносит " + getBaseAttack() + " урона");
        target.takeDamage(getBaseAttack());
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
        return getHealth() * 2 < getMaxHealth();
    }

    @Override
    public void castSpecialSkill(Hero target) {
        if (!canCast()) {
            System.out.println(getName() + " пытается ударить щитом но ничего не вышло");
            return;
        }
        int damage = getBaseAttack() + (armor * 2);
        System.out.println(getName() + " бьет щитом по " + target.getName() + " урон = " + damage);
        target.takeDamage(damage);
    }

    @Override
    public boolean needsRest() {
        return getHealth() * 100 < getMaxHealth() * 15;
    }

    @Override
    public void rest() {
        int healAmount = armor * 2;
        heal(healAmount);
        System.out.println(getName() + " отдыхает и восстанавливает " + healAmount + " хп");
    }
}

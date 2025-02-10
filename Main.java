public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int k = (int)(Math.random()*50)+1;

        for (int i = 0; i < k; i++) {
            inventory.addItem(new Item("Iron Sword", Rarity.Common));
        }

        for (int i = 0; i < (int)(k*0.8); i++) {
            inventory.addItem(new Item("Magic Wand", Rarity.Rare));
        }

        for (int i = 0; i < (int)(k/2); i++) {
            inventory.addItem(new Item("Golden Shield", Rarity.Great));
        }

        inventory.addItem(new Item("Magic Wand", Rarity.Epic));
        inventory.addItem(new Item("Magic Wand", Rarity.Epic1));
        inventory.addItem(new Item("Magic Wand", Rarity.Legendary));

        inventory.displayInventory();

        inventory.upgradeItem(new Item("Iron Sword", Rarity.Rare));
        inventory.upgradeItem(new Item("Magic Wand", Rarity.Great));
        inventory.upgradeItem(new Item("Golden Shield", Rarity.Common));

        System.out.println("\n\n\nThe inventory has been updated, and 3 items have been upgraded.\n\n\n");
        inventory.displayInventory();
    }
}
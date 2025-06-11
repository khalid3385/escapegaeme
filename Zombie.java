    package monsters;

    import player.Player;

    public class Zombie implements Monster {
        @Override
        public String getNaam() {
            return "Zombie";
        }

        @Override
        public int getSchade() {
            return 10;
        }

        @Override
        public String getBeschrijving() {
            return "Een normale zombie schuifelt op je af.";
        }

        @Override
        public void valAan(Player speler) {
            speler.decreaseHP(getSchade());
            System.out.println("🧟 " + getBeschrijving());
            System.out.println("💥 De zombie bijt! Je verliest " + getSchade() + " HP.");
        }
        @Override
        public void verwijder() {
            System.out.println("💨 De Chicken Jockey verdwijnt in het niets.");
        }

        @Override
        public void update(boolean correct) {
            if (!correct) {
                System.out.println("💢 De Zombie wordt woedend en valt aan!");
                // Roep hier `valAan(...)` aan met een geldige Player (zie toelichting hieronder)
            } else {
                System.out.println("😴 De Zombie blijft stil.");
            }
        }
    }

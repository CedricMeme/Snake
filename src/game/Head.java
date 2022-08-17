package game;

public class Head {
        // TODO überflüssigen Absatz entfernen
        /* TODO zu den Variablen dir, x und y:
            lies dir mal bitte durch was "access modifier" bzw. "Sichtbarkeitsmodifizierer" in Java sind.
            Ich sage schon mal so viel, dass du für dir, x und y keinen access modifier definiert hast.
            Informier dich mal, was in so einem Fall passiert :)

            Das gleiche sollst du auch schon in der Klasse GUI machen, hier gibt es aber einen kleinen Zusatz
            -> Wieso sind hier getter und setter definiert?
            -> Brauchst du sie hier?
        */
        Dir dir = Dir.RIGHT;
        int x, y;

        public Head(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Dir getDir() {
            return dir;
        }

        public void setDir(Dir dir) {
            this.dir = dir;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
}

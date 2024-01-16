//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class catKata {
    public static void main(String[] args) {
        String[] garden = {"--L-", "-R--", "M---"};
        int minDistance = 2;
        System.out.println("Are the cats peaceful? " + isPeaceful(garden, minDistance));
    }

    public static boolean isPeaceful(String[] yard, int minDistance) {
        int[][] catPositions = new int[3][2];
        int catCount = 0;

        // Buscar la posición de cada gato
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length(); j++) {
                char c = yard[i].charAt(j);
                if (c == 'L' || c == 'M' || c == 'R') {
                    catPositions[catCount][0] = i; // Coordenada x
                    catPositions[catCount][1] = j; // Coordenada y
                    catCount++;
                }
            }
        }

        // Calcular y comparar distancias entre cada par de gatos
        for (int i = 0; i < catCount; i++) {
            for (int j = i + 1; j < catCount; j++) {
                int dx = catPositions[i][0] - catPositions[j][0];
                int dy = catPositions[i][1] - catPositions[j][1];
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance < minDistance) {
                    return false;
                }
            }
        }
        return true;
    }
}
package ExcerciceNine;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public static void main(String[] args) {

        List<infoGames> dataJuego = new ArrayList<infoGames>();
        //Lectura y modificacion del fichero
        try{
            File archivo = new File("resume.txt");
            BufferedReader br;

            if(!archivo.exists()){

                PrintStream salida = new PrintStream("resume.txt");
                salida.println("""
                        ______________________Tabla de resultado______________________
                        Puesto   | Nombre del Jugador         | Score                \s
                        """);
            salida.close();
            }
            br = new BufferedReader(new FileReader("resume.txt"));
            br.readLine();
            String texto = br.readLine();
            while(texto != null){
                String[] textArr;
                texto = br.readLine();
                textArr = texto.replaceAll(" +", " ").split(" ");
                infoGames info = new infoGames(Integer.parseInt(textArr[0]), textArr[1], textArr[2]);
                dataJuego.add(info);
            }

            br.close();

        }catch(Exception e){
            System.out.println("El error es:"+e.getMessage());
        }
        //Empezamos el juego
        Scanner sc = new Scanner(System.in);
        boolean game = true;
        String[] jugadores = {"", ""};
        String[] fichas = {"X","0"};
        String j1 = "", j2 = "";
        String f1 = "", f2 = "";
        int turno = 0;
        String fila = "", columna = "";
        String[][] tablero = {};
        String ficha;
        String [][] jugadas = new String[0][];
        String player = "";
        boolean winner = false;
        jugadores = empezarPartidaNueva();
        while(game){
            if(turno == 0){
            jugadas = new String[][] {
                    {"","",""},
                    {"","",""},
                    {"","",""}
            };
            winner = false;
            tablero = crearTablero();
            System.out.println("Eligiremos aleatoriamente el jugador que empieza...");
            int a = ThreadLocalRandom.current().nextInt(0, 2);
            System.out.println("Empieza el jugador: "+jugadores[a]);
            j1 = jugadores[a];
            if(Objects.equals(j1, jugadores[0])) j2 = jugadores[1];
            else{
                j2 = jugadores[0];
            }
            System.out.println("Elige una ficha (Escribe X o 0).\n" +
                    "Si escribes otra cosa, se eligirá aleatoriamente:");
            f1 = sc.next().toUpperCase();
            if(!fichas[0].equals(f1) && !fichas[1].equals(f1)){
                int b = ThreadLocalRandom.current().nextInt(0, 2);
                f1 = fichas[b];
            }
            if(f1.equals(fichas[1])){
                f2 = fichas[0];
            }else {
                f2 = fichas[1];
            }
                System.out.println("Empieza el jugador :" + j1 + " con la ficha: " + f1);
            }
            System.out.println("""
                    Elige una posición de juego
                    Debes ingresar una fila y una columna (con numeros del 1 al 3).
                    Ingresa la fila:""");
            fila = sc.next();
            while(!fila.equals("1") && !fila.equals("2")&& !fila.equals("3")){
                System.out.println("El valor ingresado no hace parte del intervalo del 1-3, volver a intetarlo: ");
                fila = sc.next();
            }
            while(!Objects.equals(jugadas[Integer.parseInt(fila) - 1][0], "") && !Objects.equals(jugadas[Integer.parseInt(fila) - 1][1], "") && !Objects.equals(jugadas[Integer.parseInt(fila) - 1][2], "")){
                System.out.println("La fila seleccionada se encuentra llena, por favor elegir otra: ");
                fila = sc.next();
            }
            System.out.println("Ingresa la columna: ");
            columna = sc.next();
            while(!columna.equals("1") &&!columna.equals("2")&& !columna.equals("3")) {
                System.out.println("El valor ingresado no hace parte del intervalo del 1-3, volver a intetarlo: ");
                columna = sc.next();
            }
            while(!Objects.equals(jugadas[Integer.parseInt(fila) - 1][Integer.parseInt(columna) - 1], "")){
                System.out.println("La posición seleccionada se encuentra ocupada, por favor elegir otra columna: ");
                columna = sc.next();
            }

            if(turno % 2 == 0){
                player = j1;
                ficha = f1;
            }else{
                player = j2;
                ficha = f2;
            }
            jugadas[Integer.parseInt(fila)-1][Integer.parseInt(columna)-1] = ficha;

            tablero = pintarTablero(tablero, fila, columna, ficha.charAt(0));

            for(String[] s: tablero){
               for(String pr: s){
                   System.out.print(pr);
               }
            }

            winner = verificarGanador(jugadas);

            if (winner || turno == 9){
                System.out.println("FIN DEL JUEGO");
                newJugador(j1, j2, player, dataJuego);
                if(turno == 9){
                    System.out.println("Se ha llenado el tablero sin ningun ganador, EMPATE");
                }else {
                    System.out.println("Gana el jugador: " + player);
                }
                System.out.println("Deseas jugar nuevamente? Ingresa S para si, y N para no: ");
                String respuesta = sc.next().toUpperCase();
                while(!Objects.equals(respuesta, "S") && !Objects.equals(respuesta, "N")){
                    System.out.println("La entrada ingresada no es valida, vuelve a intentarlo: ");
                    respuesta = sc.next();
                }
                if(respuesta.equals("N")){
                    game = false;
                }else{
                    turno = -1;
                }
            }
            turno += 1;


        }
        sc.close();



    }

    private static void newJugador(String j1, String j2, String player, List<infoGames> lista) {
        boolean e1 = false;
        boolean e2 = false;
        List<String> formatos = new ArrayList<String>();
        int score = 500;
        for (ExcerciceNine.infoGames infoGames : lista) {
            if (Objects.equals(infoGames.name, j1)) {
                e1 = true;
                if(Objects.equals(j1, player)){
                    int temp = Integer.parseInt(infoGames.score);
                    infoGames.score = String.valueOf(temp+score);
                }
            }
            if (Objects.equals(infoGames.name, j2)) {
                e2 = true;
                if(Objects.equals(j2, player)){
                    int temp = Integer.parseInt(infoGames.score);
                    infoGames.score = String.valueOf(temp+score);
                }
            }
        }
        if (!e1 && Objects.equals(j1, player)){
            lista.add(new infoGames(lista.size()+1, j1, "500" ));
        }else if(!e1){
            lista.add(new infoGames(lista.size()+1, j1, "0" ));
        }
        if (!e2 && Objects.equals(j2, player)){
            lista.add(new infoGames(lista.size()+1, j2, "500" ));
        }else if(!e2){
            lista.add(new infoGames(lista.size()+1, j2, "0" ));
        }
        lista.sort(Comparator.comparing(infoGames::getScore).thenComparing(infoGames::getName));
        int cont = 1;
        for(int i = lista.size()-1; i >= 0; i--){
            lista.get(i).position = cont;
            cont ++;
        }
        for (infoGames element : (lista)) {
            String form = "";
            String tem = "";
            for(int i = 0; i < 11 - String.valueOf(element.position).length(); i++) {
                tem += " ";
            }
            form += element.position + tem;
            tem ="";
            for(int i = 0; i < 29 - element.name.length(); i++) {
                tem += " ";
            }
            form += element.name + tem + element.score+"\n";
            formatos.add(form);
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resume.txt"));
            bw.write("""
                        ______________________Tabla de resultado______________________
                        Puesto   | Nombre del Jugador         | Score                \s
                        """);
            for(int i = formatos.size() - 1; i >= 0; i--) {
                bw.write(formatos.get(i));
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String[][] crearTablero(){
        /*
        *  X | 0 |
        * -----------
        *    |   |
        * -----------
        *    |   |
        *
        */
        return new String[][]{
                {"   |   |   \n","-----------\n"},
                {"   |   |   \n","-----------\n"},
                {"   |   |   ","\n"},
        };

    }
    public static String[] empezarPartidaNueva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Empieza una nueva partida------------");
        System.out.println("Introduce el nombre del jugador 1: ");
        String j1 = sc.next();
        System.out.println("Introduce el nombre del jugador 2: ");
        String j2 = sc.next();
        return new String[]{j1, j2};
    }
    public static String[][] pintarTablero(String[][] tablero, String row, String col, char f){
        int r = Integer.parseInt(row);
        int c = Integer.parseInt(col);
        char [] arr = tablero[r-1][0].toCharArray();
        c = c*c;
        if (c == 4) c+= 1;
        arr[c] = f;
        tablero[r-1][0] = String.valueOf(arr);
        return tablero;
    }
    public static boolean verificarGanador(String[][] jugadas){
        boolean ve = false;
        for (int i = 0;i < 3; i++) {
            if(Objects.equals(jugadas[i][0], "X") && Objects.equals(jugadas[i][1], "X") && Objects.equals(jugadas[i][2], "X")
            || Objects.equals(jugadas[i][0], "0") && Objects.equals(jugadas[i][1], "0") && Objects.equals(jugadas[i][2], "0")){
                ve = true;
                break;
            }
            if(Objects.equals(jugadas[0][i], "X") && Objects.equals(jugadas[1][i], "X") && Objects.equals(jugadas[2][i], "X")
                    || Objects.equals(jugadas[0][i], "0") && Objects.equals(jugadas[1][i], "0") && Objects.equals(jugadas[2][i], "0")){
                ve = true;
                break;
            }

        }

        if (!ve && (Objects.equals(jugadas[1][1].toUpperCase(), "X") || Objects.equals(jugadas[1][1].toUpperCase(), "0"))){
            if((Objects.equals(jugadas[0][0], jugadas[1][1]) && Objects.equals(jugadas[1][1], jugadas[2][2]))||
                    (Objects.equals(jugadas[0][2], jugadas[1][1]) && Objects.equals(jugadas[1][1], jugadas[2][0]))
            ){
                ve = true;
            }
        }
        return ve;
    }
}

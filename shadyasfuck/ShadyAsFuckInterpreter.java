package vtcakavsmoace.shadyasfuck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShadyAsFuckInterpreter {
	private static Scanner quickscan;
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: java -jar ShadyAsFuck.jar <executable> [arg 1] [arg 2] ...");
			return;
		}
		File quickfile = new File(args[0]);
		String bfin = "";
		quickscan = new Scanner(quickfile);
		quickscan = quickscan.useDelimiter("\\Z");
		String content = quickscan.next();
		quickscan.close();
		String[] contarr = content.split("");
		for (int i = 0; i < contarr.length; i++) {
			switch (contarr[i]) {
				case "P": 
					contarr[i] = "++";
					break;
				case "O":
					contarr[i] = "+-";
					break;
				case "s":
					contarr[i] = "+<";
					break;
				case "h":
					contarr[i] = "+>";
					break;
				case "a":
					contarr[i] = "+[";
					break;
				case "d":
					contarr[i] = "+]";
					break;
				case "y":
					contarr[i] = "+,";
					break;
				case "_":
					contarr[i] = "+.";
					break;
				case "+":
					contarr[i] = "+";
					break;
				case "0":
					contarr[i] = "-+";
					break;
				case "M":
					contarr[i] = "--";
					break;
				case "A":
					contarr[i] = "-<";
					break;
				case "S":
					contarr[i] = "->";
					break;
				case "f":
					contarr[i] = "-[";
					break;
				case "u":
					contarr[i] = "-]";
					break;
				case "c":
					contarr[i] = "-,";
					break;
				case "k":
					contarr[i] = "-.";
					break;
				case "-":
					contarr[i] = "-";
					break;
				case "n":
					contarr[i] = "<+";
					break;
				case "G":
					contarr[i] = "<-";
					break;
				case "L":
					contarr[i] = "<<";
					break;
				case "x":
					contarr[i] = "<>";
					break;
				case "Y":
					contarr[i] = "<[";
					break;
				case "p":
					contarr[i] = "<]";
					break;
				case "Q":
					contarr[i] = "<,";
					break;
				case "J":
					contarr[i] = "<.";
					break;
				case "<":
					contarr[i] = "<";
					break;
				case "g":
					contarr[i] = ">+";
					break;
				case "m":
					contarr[i] = ">-";
					break;
				case "o":
					contarr[i] = "><";
					break;
				case "R":
					contarr[i] = ">>";
					break;
				case "5":
					contarr[i] = ">[";
					break;
				case "e":
					contarr[i] = ">]";
					break;
				case "U":
					contarr[i] = ">,";
					break;
				case "2":
					contarr[i] = ">.";
					break;
				case ">":
					contarr[i] = ">";
					break;
				case "j":
					contarr[i] = "[+";
					break;
				case "3":
					contarr[i] = "[-";
					break;
				case "b":
					contarr[i] = "[<";
					break;
				case "z":
					contarr[i] = "[>";
					break;
				case "{":
					contarr[i] = "[[";
					break;
				case "(":
					contarr[i] = "[]";
					break;
				case "I":
					contarr[i] = "[,";
					break;
				case "V":
					contarr[i] = "[.";
					break;
				case "[":
					contarr[i] = "[";
					break;
				case "W":
					contarr[i] = "]+";
					break;
				case "E":
					contarr[i] = "]-";
					break;
				case "B":
					contarr[i] = "]<";
					break;
				case "=":
					contarr[i] = "]>";
					break;
				case ")":
					contarr[i] = "][";
					break;
				case "}":
					contarr[i] = "]]";
					break;
				case "Z":
					contarr[i] = "],";
					break;
				case "T":
					contarr[i] = "].";
					break;
				case "]":
					contarr[i] = "]";
					break;
				case "t":
					contarr[i] = ",+";
					break;
				case "H":
					contarr[i] = ",-";
					break;
				case "i":
					contarr[i] = ",<";
					break;
				case "N":
					contarr[i] = ",>";
					break;
				case "K":
					contarr[i] = ",[";
					break;
				case "!":
					contarr[i] = ",]";
					break;
				case ";":
					contarr[i] = ",,";
					break;
				case "C":
					contarr[i] = ",.";
					break;
				case ",":
					contarr[i] = ",";
					break;
				case "F":
					contarr[i] = ".+";
					break;
				case "l":
					contarr[i] = ".-";
					break;
				case "4":
					contarr[i] = ".<";
					break;
				case "w":
					contarr[i] = ".>";
					break;
				case "r":
					contarr[i] = ".[";
					break;
				case "X":
					contarr[i] = ".]";
					break;
				case "D":
					contarr[i] = ".,";
					break;
				case ":":
					contarr[i] = "..";
					break;
				case ".":
					contarr[i] = ".";
					break;
			}
			bfin += contarr[i];
		}
		PrintWriter bfcode = new PrintWriter("bftemp.temp", "UTF-8");
		bfcode.print(bfin);
		bfcode.close();
		System.out.println(bfin);
        Process p = Runtime.getRuntime().exec("./main bftemp.temp "+bfin);
        p.waitFor();
        BufferedReader stdOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String s = null;
        while ((s = stdOutput.readLine()) != null) {
            System.out.println(s);
        }
	}
}

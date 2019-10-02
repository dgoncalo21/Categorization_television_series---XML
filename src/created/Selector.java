package created;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Selector
{
	public static List<String> Select() throws Exception
	{
		//user input
		Scanner sc = new Scanner(System.in);
		int restricao = -999;
		List<String> selector = new ArrayList<String>();
		int c = 0;
		while (true)
		{
			System.out.println("Escolha o parametro a limitar: ");
			System.out.println("1) Actor");
			System.out.println("2) Numero de temporadas");
			System.out.println("3) Ratings");

			int opcao = sc.nextInt();

			if (opcao == 1)
			{
				System.out.println("Introduza o nome do actor: ");
				sc.nextLine();
				String actor = sc.nextLine();
				selector.add("1");
				selector.add(actor);
			}
			else if (opcao == 2)
			{
				System.out.println("Introduza o numero minimo de temporadas: ");
				int nSeason = sc.nextInt();
				selector.add("2");
				selector.add(Integer.toString(nSeason));

			}
			else if (opcao == 3)
			{
				System.out.println("Introduza o rating minimo: ");
				Double rating = sc.nextDouble();
				selector.add("3");
				selector.add(Double.toString(rating));
			}
			else
			{
				System.out.println("Opcao invalida");
				continue;
			}
			c++;

			if (c == 3)
			{
				break;
			}
			while (true)
			{
				System.out.println("Escolha o tipo de condicao que pretende efetuar");
				System.out.println("1) AND");
				System.out.println("2) OR");
				System.out.println("3) Nao pretendo efetuar mais restricoes");
				restricao = sc.nextInt();
				if (restricao > 3 || restricao < 0)
				{
					System.out.println("Opcao invalida");
				}
				else
				{
					selector.add(Integer.toString(restricao));
					break;
				}
			}
			if (restricao == 3)
			{
				selector.remove(selector.size() - 1);
				break;
			}

		}
		sc.close();
		return selector;
	}

}

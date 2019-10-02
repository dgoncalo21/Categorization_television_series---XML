package created;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import generatedProcess.*;
import generatedProcess.Actor;
import generatedSelec.*;

public class Processor
{
	public static ACatalog Process() throws Exception
	{
		Integer c = 0; //contador para fazer os ids
		Scatalog processInit = Unmarsh.unProcess(); //criacao do objeto vindo do xml
		
		//Lista para fazer set
		ArrayList<Actor> aList = new ArrayList<Actor>();
		ArrayList<Integer> eps = new ArrayList<Integer>();
		ArrayList<Integer> top3 = new ArrayList<Integer>();
		ArrayList<Integer> top3final = new ArrayList<Integer>();
		ArrayList<String> top1st = new ArrayList<String>();
		ArrayList<String> top2nd = new ArrayList<String>();
		ArrayList<String> top3rd = new ArrayList<String>();
		ArrayList<PopActor> top1stA = new ArrayList<PopActor>();
		ArrayList<PopActor> top2ndA = new ArrayList<PopActor>();
		ArrayList<PopActor> top3rdA = new ArrayList<PopActor>();
		ArrayList<PopActor> top123 = new ArrayList<PopActor>();

		ACatalog posProcess = new ACatalog();

		for (int i = 0; i < processInit.getSerie().size(); i++) //atribuir ao ator a serie, episodios, etc
		{
			for (int j = 0; j < processInit.getSerie().get(i).getActor().size(); j++)
			{
				BigInteger c1 = BigInteger.valueOf(c.intValue());

				Actor placeHolder = new Actor();
				placeHolder.setId(c1);
				placeHolder.setName(processInit.getSerie().get(i).getActor().get(j).getName());
				placeHolder.addSerieTitle(processInit.getSerie().get(i).getTitle());
				placeHolder.setEpFeat(processInit.getSerie().get(i).getNEps());

				c = c + 1;

				aList.add(placeHolder); //lista de atores a adicionar ao catalogo


			}
		}

		for (int i = 0; i < aList.size(); i++) //analisar atores com o mesmo nome (que participam em mais que uma serie)
											   //remove o ator repetido adicionando a serie e os episodios da mesma
		{
			Actor placeHolder1 = aList.get(i);
			if (i == aList.size())
			{
				break;
			}
			for (int j = i + 1; j < aList.size(); j++)
			{
				Actor placeHolder2 = aList.get(j);
				if (placeHolder1.getName().equals(placeHolder2.getName()))
				{
					Integer totalEp1 = placeHolder1.getEpFeat().intValue();
					Integer totalEp2 = placeHolder2.getEpFeat().intValue();
					Integer totalEp = totalEp1 + totalEp2;
					BigInteger totEp = BigInteger.valueOf(totalEp.intValue());

					placeHolder1.setEpFeat(totEp);
					placeHolder1.addSerieTitle(placeHolder2.getSerieTitle().get(0));

					aList.remove(j);
				}
			}
		}

		for (int i = 0; i < aList.size(); i++) //organizar as series por ordem alfabetica
		{
			Collections.sort(aList.get(i).getSerieTitle());
			eps.add(aList.get(i).getEpFeat().intValue());
		}

		boolean top3add = false;
		for (int i = 0; i < eps.size(); i++) //criar as listas topActor
		{
			if (top3.size() == 0)
			{
				top3.add(eps.get(i));
			}
			else
			{
				for (int j = 0; j < top3.size(); j++)
				{
					if (eps.get(i) == top3.get(j))
					{
						top3add = false;
						break;
					}
					else
					{
						top3add = true;
					}
				}
			}
			if (top3add)
			{
				top3.add(eps.get(i));
			}
		}

		Collections.sort(top3); //organizar por numeros de eps

		while (top3.size() < 3) //corrigir o erro do size
		{
			top3.add(0);
		}

		Integer top3first = top3.get(top3.size() - 1);
		Integer top3second = top3.get(top3.size() - 2);
		Integer top3third = top3.get(top3.size() - 3);
		top3final.add(top3first);
		top3final.add(top3second);
		top3final.add(top3third);

		for (int i = 0; i < aList.size(); i++)
		{
			Integer epNum = aList.get(i).getEpFeat().intValue();
			if (epNum == top3final.get(0))
			{
				top1st.add(aList.get(i).getName());
			}
			if (epNum == top3final.get(1))
			{
				top2nd.add(aList.get(i).getName());
			}
			if (epNum == top3final.get(2))
			{
				top3rd.add(aList.get(i).getName());
			}
		}

		BigInteger atoresProcess = BigInteger.valueOf(aList.size()); //numero de atores processados

		for (int i = 0; i < top1st.size(); i++)
		{
			PopActor placeHolder = new PopActor();
			placeHolder.setName(top1st.get(i));
			placeHolder.setEps(BigInteger.valueOf(top3final.get(0)));
			top1stA.add(placeHolder);
			top123.add(placeHolder);
		}
		for (int i = 0; i < top2nd.size(); i++)
		{
			PopActor placeHolder = new PopActor();
			placeHolder.setName(top2nd.get(i));
			placeHolder.setEps(BigInteger.valueOf(top3final.get(1)));
			top2ndA.add(placeHolder);
			top123.add(placeHolder);
		}
		for (int i = 0; i < top3rd.size(); i++)
		{
			PopActor placeHolder = new PopActor();
			placeHolder.setName(top3rd.get(i));
			placeHolder.setEps(BigInteger.valueOf(top3final.get(2)));
			top3rdA.add(placeHolder);
			top123.add(placeHolder);
		}

		posProcess.setProcAtor(atoresProcess);
		posProcess.setActor(aList);
		posProcess.setListPopActor(top123);

		return posProcess;

	}
}

package created;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import generatedSelec.Scatalog;
import generatedSelec.Serie;

public class serieSelec
{
	public static List<Serie> Select(List<String> selector) throws Exception
	{
		Scatalog oldCatalog = Unmarsh.unCatal(); //unmarsh do xml para objeto
		//novas listas para fazer set ao objeto
		List<Serie> novaLista = new ArrayList<Serie>();
		List<Serie> novaLista1 = new ArrayList<Serie>();
		List<Serie> novaLista2 = new ArrayList<Serie>();
		List<Serie> novaLista3 = new ArrayList<Serie>();
		boolean orAnd = false;

		if (selector.size() == 8)
		{
			if (selector.get(2).equals("2") && selector.get(5).equals("1")) // OR e AND
			{
				orAnd = true;
				if (selector.get(0).equals("1")) // Ator
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
						{
							if (selector.get(1).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																													// tiver
																													// o
																													// nome
																													// do
																													// ator
							{
								if (selector.get(6).equals("1")) // ator
								{
									for (int k = 0; k < oldCatalog.getSerie().get(i).getActor().size(); k++)
									{
										if (selector.get(7)
												.equals(oldCatalog.getSerie().get(i).getActor().get(k).getName())) // se
																													// tiver
																													// o
																													// nome
																													// do
																													// ator
										{
											novaLista.add(oldCatalog.getSerie().get(i));
										}
									}
								}
								else if (selector.get(6).equals("2")) // season
								{
									BigInteger value = new BigInteger(selector.get(7));
									if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
									{
										novaLista.add(oldCatalog.getSerie().get(i));
									}
								}
								else if (selector.get(6).equals("3")) // rating
								{
									BigDecimal rvalue = new BigDecimal(selector.get(7));
									if (rvalue
											.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
									{
										novaLista.add(oldCatalog.getSerie().get(i));
									}
								}
								// novaLista.add(oldCatalog.getSerie().get(i));
							}
						}
					}
				}
				if (selector.get(0).equals("2")) // Seasons
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						BigInteger value = new BigInteger(selector.get(1));
						if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
						{
							if (selector.get(6).equals("1")) // ator
							{
								for (int k = 0; k < oldCatalog.getSerie().get(i).getActor().size(); k++)
								{
									if (selector.get(7)
											.equals(oldCatalog.getSerie().get(i).getActor().get(k).getName())) // se
																												// tiver
																												// o
																												// nome
																												// do
																												// ator
									{
										novaLista.add(oldCatalog.getSerie().get(i));
									}
								}
							}
							else if (selector.get(6).equals("2")) // season
							{
								BigInteger Svalue = new BigInteger(selector.get(7));
								if (Svalue.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
								{
									novaLista.add(oldCatalog.getSerie().get(i));
								}
							}
							else if (selector.get(6).equals("3")) // rating
							{
								BigDecimal rvalue = new BigDecimal(selector.get(7));
								if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
								{
									novaLista.add(oldCatalog.getSerie().get(i));
								}
							}
						}
					}
				}
				if (selector.get(0).equals("3")) // Rating
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						BigDecimal rvalue = new BigDecimal(selector.get(1));

						if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
						{
							if (selector.get(6).equals("1")) // ator
							{
								for (int k = 0; k < oldCatalog.getSerie().get(i).getActor().size(); k++)
								{
									if (selector.get(7)
											.equals(oldCatalog.getSerie().get(i).getActor().get(k).getName())) // se
																												// tiver
																												// o
																												// nome
																												// do
																												// ator
									{
										novaLista.add(oldCatalog.getSerie().get(i));
									}
								}
							}
							else if (selector.get(6).equals("2")) // season
							{
								BigInteger value = new BigInteger(selector.get(7));
								if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
								{
									novaLista.add(oldCatalog.getSerie().get(i));
								}
							}
							else if (selector.get(6).equals("3")) // rating
							{
								BigDecimal r2value = new BigDecimal(selector.get(7));
								if (r2value.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
								{
									novaLista.add(oldCatalog.getSerie().get(i));
								}
							}
						}
					}
				}
				// FAZER AQUI O OR
				if (selector.get(3).equals("1"))
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
						{
							if (selector.get(4).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																													// tiver
																													// o
																													// nome
																													// do
																													// ator
							{
								novaLista.add(oldCatalog.getSerie().get(i));
							}
						}
					}
				}
				else if (selector.get(3).equals("2")) // Seasons
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						BigInteger value = new BigInteger(selector.get(4));
						if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
						{
							novaLista.add(oldCatalog.getSerie().get(i));
						}
					}
				}
				else if (selector.get(3).equals("3")) // rating
				{
					for (int i = 0; i < oldCatalog.getSerie().size(); i++)
					{
						BigDecimal rvalue = new BigDecimal(selector.get(4));
						if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
						{
							novaLista.add(oldCatalog.getSerie().get(i));
						}
					}
				}
			}
		}
		// CASO GERAL

		int size = selector.size();
		if (selector.get(0).equals("1")) // Ator
		{
			for (int i = 0; i < oldCatalog.getSerie().size(); i++)
			{
				for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
				{
					if (selector.get(1).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																											// tiver
																											// o
																											// nome
																											// do
																											// ator

					{
						novaLista1.add(oldCatalog.getSerie().get(i));
					}
				}
			}
		}
		else if (selector.get(0).equals("2")) //season
		{
			for (int i = 0; i < oldCatalog.getSerie().size(); i++)
			{
				BigInteger value = new BigInteger(selector.get(1));
				if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
				{
					novaLista1.add(oldCatalog.getSerie().get(i));
				}
			}
		}
		else if (selector.get(0).equals("3")) //rating
		{
			for (int i = 0; i < oldCatalog.getSerie().size(); i++)
			{
				BigDecimal rvalue = new BigDecimal(selector.get(1));
				if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
				{
					novaLista1.add(oldCatalog.getSerie().get(i));
				}
			}
		}

		if (size == 5)
		{
			if (selector.get(3).equals("1")) // Ator
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
					{
						if (selector.get(4).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																												// tiver
																												// o
																												// nome
																												// do
																												// ator

						{
							novaLista2.add(oldCatalog.getSerie().get(i));
						}
					}
				}
			}
			else if (selector.get(3).equals("2")) //season
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigInteger value = new BigInteger(selector.get(4));
					if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
					{
						novaLista2.add(oldCatalog.getSerie().get(i));
					}
				}
			}
			else if (selector.get(3).equals("3")) //rating
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigDecimal rvalue = new BigDecimal(selector.get(4));
					if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
					{
						novaLista2.add(oldCatalog.getSerie().get(i));
					}
				}
			}
		}
		else if (size == 8)
		{
			if (selector.get(3).equals("1")) // Ator
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
					{
						if (selector.get(4).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																												// tiver
																												// o
																												// nome
																												// do
																												// ator

						{
							novaLista2.add(oldCatalog.getSerie().get(i));
						}
					}
				}
			}
			else if (selector.get(3).equals("2")) //season
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigInteger value = new BigInteger(selector.get(4));
					if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
					{
						novaLista2.add(oldCatalog.getSerie().get(i));
					}
				}
			}
			else if (selector.get(3).equals("3")) //rating
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigDecimal rvalue = new BigDecimal(selector.get(4));
					if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
					{
						novaLista2.add(oldCatalog.getSerie().get(i));
					}
				}
			}
			if (selector.get(6).equals("1")) // Ator
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					for (int j = 0; j < oldCatalog.getSerie().get(i).getActor().size(); j++)
					{
						if (selector.get(7).equals(oldCatalog.getSerie().get(i).getActor().get(j).getName())) // se
																												// tiver
																												// o
																												// nome
																												// do
																												// ator

						{
							novaLista3.add(oldCatalog.getSerie().get(i));
						}
					}
				}
			}
			else if (selector.get(6).equals("2")) //season
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigInteger value = new BigInteger(selector.get(7));
					if (value.compareTo(oldCatalog.getSerie().get(i).getNSeasons()) <= 0)
					{
						novaLista3.add(oldCatalog.getSerie().get(i));
					}
				}
			}
			else if (selector.get(6).equals("3")) //rating
			{
				for (int i = 0; i < oldCatalog.getSerie().size(); i++)
				{
					BigDecimal rvalue = new BigDecimal(selector.get(7));
					if (rvalue.compareTo(oldCatalog.getSerie().get(i).getRating().get(0).getValue()) <= 0)
					{
						novaLista3.add(oldCatalog.getSerie().get(i));
					}
				}
			}
		}
		if (orAnd == false)
		{
			if (size == 5)
			{
				if (selector.get(2).equals("1")) //ator
				{
					for (int i = 0; i < novaLista1.size(); i++)
					{
						Serie serie1 = novaLista1.get(i);
						for (int j = 0; j < novaLista2.size(); j++)
						{
							Serie serie2 = novaLista2.get(j);
							if (serie1.getTitle().equals(serie2.getTitle()))
							{
								novaLista.add(serie1);
							}
						}
					}
				}
				else if (selector.get(2).equals("2")) //season
				{
					for (int i = 0; i < novaLista1.size(); i++)
					{
						Serie serie1 = novaLista1.get(i);
						novaLista.add(serie1);
					}
					for (int i = 0; i < novaLista2.size(); i++)
					{
						Serie serie2 = novaLista2.get(i);
						novaLista.add(serie2);
					}
				}
			}
			else if (size == 8)
			{
				if (selector.get(2).equals("1")) // 1o AND
				{
					for (int i = 0; i < novaLista1.size(); i++)
					{
						Serie serie1 = novaLista1.get(i);
						for (int j = 0; j < novaLista2.size(); j++)
						{
							Serie serie2 = novaLista2.get(j);
							if (serie1.getTitle().equals(serie2.getTitle()))
							{

								for (int k = 0; k < novaLista3.size(); k++)
								{
									Serie serie3 = novaLista3.get(k);
									if (selector.get(5).equals("1") && serie1.getTitle().equals(serie3.getTitle())) // 2o
																													// AND
									{
										novaLista.add(serie1);
									}
									else if (selector.get(5).equals("2")) // 2o OR
									{
										novaLista.add(serie1);
										novaLista.add(serie3);
									}
								}
							}
							else
							{
								if (selector.get(5).equals("2"))
								{
									for (int k = 0; k < novaLista3.size(); k++)
									{
										Serie serie3 = novaLista3.get(k);
										novaLista.add(serie3);
									}
								}
							}
						}
					}
				}
				else if (selector.get(2).equals("2")) // 1o OR
				{
					for (int i = 0; i < novaLista1.size(); i++)
					{
						Serie serie1 = novaLista1.get(i);
						novaLista.add(serie1);
					}
					for (int i = 0; i < novaLista2.size(); i++)
					{
						Serie serie2 = novaLista2.get(i);
						novaLista.add(serie2);
					}
					for (int i = 0; i < novaLista3.size(); i++)
					{
						Serie serie3 = novaLista3.get(i);
						novaLista.add(serie3);
					}
				}
			}
			else // Se nao tiver condicao
			{
				for (int i = 0; i < novaLista1.size(); i++)
				{
					Serie serie1 = novaLista1.get(i);
					novaLista.add(serie1);
				}
			}
		}

		List<Serie> novaListaFinal = new ArrayList<Serie>();

		for (int i = 0; i < novaLista.size(); i++)
		{
			if (novaListaFinal.contains(novaLista.get(i)) == false)
			{
				novaListaFinal.add(novaLista.get(i));
			}
		}

		novaLista = novaListaFinal;
		return novaLista;
	}
}

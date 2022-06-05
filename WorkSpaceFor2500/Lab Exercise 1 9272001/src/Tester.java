
public class Tester
{
	static long perms; // How many permutations did we identify?
	static int size; // What's the size of the set we're permuting (the first "size" elements of A)
	static String format = "%-11s %d permutations in %15.10f seconds (%9d permutations / second)\n";

	public static void main(String[] args)
	{
		long time; // What time did we start this test?
		double elapsed; // What was the elapsed time for all repetitions of this test (in seconds)?

		long reps = 10000000000L; // How many repetitions to run (to average out variation)
		size = 3; // How large is the set we're permuting?

		long fact = 1;
		for (int i = size; i > 1; fact *= i--)
			; // compute size!
		System.out.println("Size: " + size + " (" + size + "! = " + fact + ")"); // Output size & target count

		perms = 0; // We've not generated any permutations yet
		time = System.nanoTime(); // mark the start time
		for (long times = 1; times <= reps; times++) // repeat test, to average out variations in run time
		{
			int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
			switch (size)
			{
			case 1:
			{
				generate01(A);
				break;
			}
			case 2:
			{
				generate02(A);
				break;
			}
			case 3:
			{
				generate03(A);
				break;
			}
			case 4:
			{
				generate04(A);
				break;
			}
			case 5:
			{
				generate05(A);
				break;
			}
			case 6:
			{
				generate06(A);
				break;
			}
			case 7:
			{
				generate07(A);
				break;
			}
			case 8:
			{
				generate08(A);
				break;
			}
			case 9:
			{
				generate09(A);
				break;
			}
			case 10:
			{
				generate10(A);
				break;
			}
			case 11:
			{
				generate11(A);
				break;
			}
			case 12:
			{
				generate12(A);
				break;
			}}
		}
		elapsed = ((System.nanoTime() - time) / 1000000000.0 / reps);
		System.out.printf(format, "Naive for", perms / reps, elapsed, (long) (perms / elapsed / reps));
	} // end main

	public static void generate01(int[] A)
	{
		perms++;
		//System.out.println(A[0]);
	}

	public static void generate02(int[] A)
	{
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				if (i != j)
				{
					perms++;
					//System.out.println(A[i] + " " + A[j]);
				}
	}

	public static void generate03(int[] A)
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					if(i != j && k != i && k != j)
					{
						perms++;
						//System.out.println(A[i] + " " + A[j] + " " + A[k]);
					}
	}

	public static void generate04(int[] A)
	{
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (i != j)
				for (int k = 0; k < 4; k++)
					if (k != i && k != j)
					for (int l = 0; l < 4; l++)
						if (i != l && j != l && k != l)
						{
							perms++;
							//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l]);
						}
	}

	public static void generate05(int[] A)
	{
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				if (i != j)
				for (int k = 0; k < 5; k++)
					if (k != i && k != j)
					for (int l = 0; l < 5; l++)
						if (l != i && l != j && l != k)
						for (int m = 0; m < 5; m++)
							if (m != i && m != j && m != k && m != l)
							{
								perms++;
								//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m]);
							}
	}
	
	public static void generate06(int[] A)
	{
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++)
				if (i != j)
				for (int k = 0; k < 6; k++)
					if (k != i && k != j)
					for (int l = 0; l < 6; l++)
						if (l != i && l != j && l != k)
						for (int m = 0; m < 6; m++)
							if (m != i && m != j && m != k && m != l)
							for (int n = 0; n < 6; n++)
								if (n != i && n != j && n != k && n != l && n != m)
								{
									perms++;
									//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n]);
								}
	}
	
	public static void generate07(int[] A)
	{
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 7; j++)
				if (i != j)
				for (int k = 0; k < 7; k++)
					if (k != i && k != j)
					for (int l = 0; l < 7; l++)
						if (l != i && l != j && l != k)
						for (int m = 0; m < 7; m++)
							if (m != i && m != j && m != k && m != l)
							for (int n = 0; n < 7; n++)
								if (n != i && n != j && n != k && n != l && n != m)
								for (int o = 0; o < 7; o++)
									if (o != i && o != j && o != k && o != l && o != m && o != n)
									{
										perms++;
										//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o]);
									}
	}
	
	public static void generate08(int[] A)
	{
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (i != j)
				for (int k = 0; k < 8; k++)
					if (k != i && k != j)
					for (int l = 0; l < 8; l++)
						if (l != i && l != j && l != k)
						for (int m = 0; m < 8; m++)
							if (m != i && m != j && m != k && m != l)
							for (int n = 0; n < 8; n++)
								if (n != i && n != j && n != k && n != l && n != m)
								for (int o = 0; o < 8; o++)
									if (o != i && o != j && o != k && o != l && o != m && o != n)
									for (int p = 0; p < 8; p++)
										if (p != i && p != j && p != k && p != l && p != m && p != n && p != o)
										{
											perms++;
											//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + A[p]);
										}
	}
	
	public static void generate09(int[] A)
	{
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				for (int k = 0; k < 9; k++)
					for (int l = 0; l < 9; l++)
						for (int m = 0; m < 9; m++)
							for (int n = 0; n < 9; n++)
								for (int o = 0; o < 9; o++)
									for (int p = 0; p < 9; p++)
										for (int q = 0; q < 9; q++)
											if (i != j && k != i && k != j && l != i && l != j && l != k && m != i && m != j && m != k && m != l &&
													n != i && n != j && n != k && n != l && n != m && o != i && o != j && o != k && o != l && o != m && o != n &&
													p != i && p != j && p != k && p != l && p != m && p != n && p != o && q != i && q != j && q != k && q != l && q != m && q != n && q != o && q != p)
											{
												perms++;
												//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + 
												//				   A[p] + " " + A[q]);
											}
	}
	
	public static void generate10(int[] A)
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 9; j++)
				for (int k = 0; k < 10; k++)
					for (int l = 0; l < 10; l++)
						for (int m = 0; m < 10; m++)
							for (int n = 0; n < 10; n++)
								for (int o = 0; o < 10; o++)
									for (int p = 0; p < 10; p++)
										for (int q = 0; q < 10; q++)
											for (int r = 0; r < 10; r++)
												if (r != i && r != j && r != k && r != l && r != m && r != n && r != o && r != p && r != q && 
													i != j && k != i && k != j && l != i && l != j && l != k && m != i && m != j && m != k && m != l &&
														n != i && n != j && n != k && n != l && n != m && o != i && o != j && o != k && o != l && o != m && o != n &&
														p != i && p != j && p != k && p != l && p != m && p != n && p != o && q != i && q != j && q != k && q != l && q != m && q != n && q != o && q != p)
												{
													perms++;
													//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + 
													//				   A[p] + " " + A[q] + " " + A[r]);
												}
	}
	
	public static void generate11(int[] A)
	{
		for (int i = 0; i < 11; i++)
			for (int j = 0; j < 11; j++)
				for (int k = 0; k < 11; k++)
					for (int l = 0; l < 11; l++)
						for (int m = 0; m < 11; m++)
							for (int n = 0; n < 11; n++)
								for (int o = 0; o < 11; o++)
									for (int p = 0; p < 11; p++)
										for (int q = 0; q < 11; q++)
											for (int r = 0; r < 11; r++)
												for (int s = 0; s < 11; s++)
													if (s != i && s != j && s != k && s != l && s != m && s != n && s != o && s != p && s != q && s != r &&
															i != j && k != i && k != j && l != i && l != j && l != k && m != i && m != j && m != k && m != l &&
															n != i && n != j && n != k && n != l && n != m && o != i && o != j && o != k && o != l && o != m && o != n &&
															p != i && p != j && p != k && p != l && p != m && p != n && p != o && q != i && q != j && q != k && q != l && q != m && q != n && q != o && q != p &&
															r != i && r != j && r != k && r != l && r != m && r != n && r != o && r != p && r != q)
													{
														perms++;
														//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + 
														//				   A[p] + " " + A[q] + " " + A[r] + " " + A[s]);
													}
	}
	
	public static void generate12(int[] A)
	{
		for (int i = 0; i < 12; i++)
			for (int j = 0; j < 12; j++)
				if (i != j)
				for (int k = 0; k < 12; k++)
					if (k != i && k != j)
					for (int l = 0; l < 12; l++)
						if (l != i && l != j && l != k)
						for (int m = 0; m < 12; m++)
							if (m != i && m != j && m != k && m != l)
							for (int n = 0; n < 12; n++)
								if (n != i && n != j && n != k && n != l && n != m)
								for (int o = 0; o < 12; o++)
									if (o != i && o != j && o != k && o != l && o != m && o != n)
									for (int p = 0; p < 12; p++)
										if (p != i && p != j && p != k && p != l && p != m && p != n && p != o)
										for (int q = 0; q < 12; q++)
											if (q != i && q != j && q != k && q != l && q != m && q != n && q != o && q != p)
											for (int r = 0; r < 12; r++)
												if (r != i && r != j && r != k && r != l && r != m && r != n && r != o && r != p && r != q)
												for (int s = 0; s < 12; s++)
													if (s != i && s != j && s != k && s != l && s != m && s != n && s != o && s != p && s != q && s != r)
													for (int t = 0; t < 12; t++)
														if (t != i && t != j && t != k && t != l && t != m && t != n && t != o && t != p && t != q && t != r && t != s)
														{
															perms++;
															//System.out.println(A[i] + " " + A[j] + " " + A[k] + " " + A[l] + " " + A[m] + " " + A[n] + " " + A[o] + " " + 
															//				   A[p] + " " + A[q] + " " + A[r] + " " + A[s]);
														}
	}

} // end class
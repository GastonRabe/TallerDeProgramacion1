package test;

import org.junit.Test;

import codigo.Codigo;

public class Canal1Test {

	@Test
	public void test() {
		float[][] mat = new float[4][4];
		int i,j;
		for(i=0;i<4;i++)
			for(j=0;j<4;j++) {
				if(i==j)
					mat[i][j]=1;
				else
					mat[i][j]=0;
			}
		mat[1][2]=-1;
		mat[1][3]=1;
		Codigo.canal1(mat);
	}

}

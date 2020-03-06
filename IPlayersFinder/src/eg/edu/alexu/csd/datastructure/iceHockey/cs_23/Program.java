package eg.edu.alexu.csd.datastructure.iceHockey.cs_23;

import java.awt.Point;

public class Program implements IPlayersFinder
{
	
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
	{
		if (photo == null)return new java.awt.Point[] {};
		java.awt.Point[] Points;
		Points = GetPoints(photo,team);
		java.awt.Point[][]Related_Points= Find_Relations(Points);
		Filter(Related_Points);
		java.awt.Point[] Center =GetCenter(Related_Points,threshold);
		java.awt.Point[] Final_Result =Rearrange_Points(Center);
		return Final_Result;
	}
	public java.awt.Point[] Rearrange_Points(java.awt.Point[] arr)
	{
		//This function rearranges the result as required and remove all the null
		int count = 0;
		for (int i = 0 ; i < arr.length;i++)
		{
			if (arr[i]!=null)count++;
			else break;
		}
		java.awt.Point[] Final_Result = new java.awt.Point[count];
		int index1 = count-1 ;
		for (int i = 0 ; i < count ; i++)
		{
			int index2 = 0 ;
			int maxx=-1,maxy=-1;
			for (int j = 0 ; j < count ; j++)
			{
				if(arr[j]==null)continue;
				if (arr[j].x >maxx ||(arr[j].x==maxx&&arr[j].y>maxy))
				{
					index2 = j;
					maxx=arr[j].x;
					maxy=arr[j].y;
				}
			}
			Final_Result[index1]= arr[index2];
			index1--;
			arr[index2] = null;
		}
		return Final_Result;
	}
	public java.awt.Point[] GetCenter(java.awt.Point[][] ref,int threshhold)
	{
		//This Function sees if the body if bigger than the threshhold 
		//and if so it will get the mid of the body
		java.awt.Point[] Mid = new java.awt.Point[ref.length];
		if (ref.length==1&&ref[0].length==1&&threshhold<=4)return new java.awt.Point[] {new java.awt.Point(1,1)};
		int Index = 0;
		for (int i = 0 ; i < ref.length;i++)
		{
			if (ref[i]==null)break;
			
			int Min_X = ref[i][0].y;
			int Min_Y = ref[i][0].x;
			int Max_X = ref[i][0].y;
			int Max_Y = ref[i][0].x;
			int size = 1;
			for (int j = 1 ; j < ref.length;j++)
			{
				if (ref[i][j]==null)
				{
					size*=4;
					if(size>=threshhold)
					{
						int Mid_X = (2*Min_X+(Max_X+1)*2)/2;
						int Mid_Y = (2*Min_Y+(Max_Y+1)*2)/2;
						Mid[Index] = new java.awt.Point(Mid_X,Mid_Y);
						Index++;
					}
					break;
				}
				if(ref[i][j].y<Min_X)
				{
					Min_X = ref[i][j].y;
				}else if (ref[i][j].y>Max_X)
				{
					Max_X = ref[i][j].y;
				}
				if(ref[i][j].x<Min_Y)
				{
					Min_Y = ref[i][j].x;
				}else if (ref[i][j].x>Max_Y)
				{
					Max_Y = ref[i][j].x;
				}
				size++;
				if (j==ref.length-1)
				{
					size*=4;
					if(size>=threshhold)
					{
						int Mid_X = (2*Min_X+(Max_X+1)*2)/2;
						int Mid_Y = (2*Min_Y+(Max_Y+1)*2)/2;
						Mid[Index] = new java.awt.Point(Mid_X,Mid_Y);
						Index++;
					}
					break;
				}
			}
		}
		return Mid;
	}
	public void Filter(java.awt.Point[][] ref)
	{
		//This function filters and merge the commons
		int send = 1;
		for (int x = 0 ; x <ref.length;)
		{				
			if (ref[x]==null)break;
			for(int y = 0 ;y < ref.length;y++)
			{
				if (ref[x][y]==null)
				{
				x++;
				break;
				}
				for (int i = x+1 ; i<ref.length;i++)
				{
					if (i ==x)continue;
					if (ref[i]==null)break;
					for(int j =0;j<ref.length;j++)
					{
						if (ref[i][j]==null)break;
						if (ref[x][y].equals(ref[i][j]))
						{
							if (x<i)
							{
								Sort_Points(ref,x,i);
							}
							else
							{
								Sort_Points(ref,i,x);
							}
							ref[i]=null;
							Rearrage(ref,i,send);
							send++;
							j=-1;
							i = x+1;
							if (ref[i]==null)break;
						}
					}
				}
				if (y == ref.length-1)x++;
			}
		}
	}
	public void Rearrage(java.awt.Point[][] ref, int start,int send)
	{
		//This function rearranges the array after doing a change
		for (int i = start;i<ref.length-1;i++)
		{
			if(ref[i+1]==null)break;
			ref[i]=ref[i+1];
		}
		ref[ref.length-send]=null;
	}
	public void Sort_Points(java.awt.Point[][] ref,int main,int sub)
	{
		for (int i = 0;i<3;i++)
		{
			if (ref[sub][i]==null)break;
			for(int j = 0 ; j < ref.length;j++)
			{
				if (ref[main][j] == null)
				{
					ref[main][j]= ref[sub][i];
					break;
				}
				if (ref[main][j].equals(ref[sub][i]))break;
			}
		}
	}
	public java.awt.Point[][] Find_Relations (java.awt.Point[] Points)
	{
		//This function returns 2d array with points which are related to each other
		java.awt.Point[][]Points_Related = new java.awt.Point[Points.length][Points.length];
		int X = 0;
		while (X<Points.length)
		{
			Points_Related[X][0] = Points[X];
			int Y = 1;
			for(int i = X+1 ; i < Points.length ; i++ )
			{
				if (Points[i].x-Points_Related[X][0].x >1)break;
				if ((Points[i].x-Points_Related[X][0].x)+
						Math.abs((Points[i].y-Points_Related[X][0].y))==1)
				{
					Points_Related[X][Y] = Points[i];
					Y++;
				}
			}
			X++;
		}
		return Points_Related;
	}
	public static java.awt.Point[] GetPoints(String[] photo,int team) 
	{
		//This function returns points of all the indexes of number of the team
		int count=0;
		for (int i = 0;i<photo.length;i++)
		{
			for(int j = 0 ; j < photo[i].length();j++)
			{
				if (photo[i].charAt(j)==String.valueOf(team).charAt(0))count++;
			}
		}
		java.awt.Point Points [] = new java.awt.Point[count];
		int index = 0;
		for (int i = 0;i<photo.length;i++)
		{
			for(int j = 0 ; j < photo[i].length();j++)
			{
				if(photo[i].charAt(j)==String.valueOf(team).charAt(0))
				{
					Points[index] = new java.awt.Point(i,j);
					index++;
					if (index == count)return Points;
				}
			}
		}
		return Points;
	}
}
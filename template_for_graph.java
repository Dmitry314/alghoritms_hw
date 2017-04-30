package hackerrank;

import java.util.*;
public class task1 {

	
	
	
	
	public static class vertex{
		
		public int color;
		public int number;
		public ArrayList<vertex> acces_vertx = new ArrayList<>();
		
		public boolean used = false;
		
		public boolean  get_used(){
			
			return this.used;
			
		}
		
		public void set_used(){
			this.used = true;
			
			
		}
		
		public vertex(int i){
			this.number = i;
		}
		
		
	}
	
	
	public static class Adjacency_component{
		
		
		public ArrayList<vertex> vertexes = new ArrayList<>();
		
		
		
		public void add(vertex t){
			vertexes.add(t);
			
			
			
		}
		
		
	}
	
	public static class graph{
		
		public ArrayList<vertex> data = new ArrayList<>();
		public int size;
		
		
		public void dfs(vertex start, int color1){
			
			if(start.get_used() == false){
				
				start.set_used();
				start.color = color1;
				
				
				
				
				for(vertex curr : start.acces_vertx){
					if(!curr.used){
						
						dfs(curr, color1);
											
					}					
				}			
			}			
		}
		
		public ArrayList<Adjacency_component> do_dfs(){
			
			ArrayList<Adjacency_component> comp = new ArrayList<>();
			
			int color = 0;
			for(int i =0; i < this.data.size(); ++i){
				
				if(this.data.get(i).used == false){
					dfs(data.get(i), color);
					color = color + 1;
				}
				
				
			}
			for(int i =0; i < color; ++i){
				comp.add(new Adjacency_component());
				
				
			}
			for(int i =0; i < this.data.size(); ++i){
				
				comp.get(data.get(i).color).add(data.get(i));
				
			}
			
			return comp;
		}
		
		
		public graph(int size){
			this.size = size;
			for(int i =0; i< size ; ++i){
				
				this.data.add(new vertex(i));
				
			}
			
		}
		
		
		public void add_node(int a, int b){
		
			data.get(a).acces_vertx.add(data.get(b));
			data.get(b).acces_vertx.add(data.get(a));//magic
			
		}
		
	}
	
	
	public static class box{
		int a;
		int  b;
		
		public box(){
			this.a =1;
			this.b = 1;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(t);
		Scanner in  = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			long answer = 0;
			int n = in.nextInt();
			long m = in.nextLong();
			long x = in.nextLong();
			long y = in.nextLong();
			
			graph kingdom = new graph(n);
			for(long a1 = 0; a1 < m; a1++){
				
				int city_1 = in.nextInt();
				int city_2 = in.nextInt();
				
				kingdom.add_node(city_1 - 1, city_2 - 1);
				
			}
			
			if(y > x){
				answer = n*x;
			}
			else{
				
				ArrayList<Adjacency_component> components = kingdom.do_dfs();
				answer = components.size()*x;
				for(Adjacency_component my_cmp: components){
					
					answer = answer + (long)(my_cmp.vertexes.size()-1)*y;
					
					
				}
				
				
			}
			
			System.out.println(answer);
		
		}
		
		in.close();
	}

	private static int getWays(int[] s, int d, int m) {
		// TODO Auto-generated method stub
		int res = 0;
		int current_sum;
		
		for(int i =0 ; i < s.length ; ++i){
			if( i + d - 1 < s.length){
				
				current_sum = 0;
				for(int j =i ; j < i + d; ++j){
					
					current_sum = current_sum + s[j];
					
				}
				System.out.println(i + " " + (i + d -1) + " " + current_sum);
				
				if(current_sum == m){
					res = res + 1;
				}
				
			}
			
			
		}
		
		return res;
	}

}

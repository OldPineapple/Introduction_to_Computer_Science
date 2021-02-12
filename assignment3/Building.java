package assignment3;
//Name:Hanwen Wang      ID:260778557      Course:COMP 250
public class Building {

	OneBuilding data;
	Building older;
	Building same;
	Building younger;
	
	public Building(OneBuilding data){
		this.data = data;
		this.older = null;
		this.same = null;
		this.younger = null;
	}
	
	public String toString(){
		String result = this.data.toString() + "\n";
		if (this.older != null){
			result += "older than " + this.data.toString() + " :\n";
			result += this.older.toString();
		}
		if (this.same != null){
			result += "same age as " + this.data.toString() + " :\n";
			result += this.same.toString();
		}
		if (this.younger != null){
			result += "younger than " + this.data.toString() + " :\n";
			result += this.younger.toString();
		}
		return result;
	}
	
	public Building addBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		Building obToAdd=new Building (b);
		if (b.yearOfConstruction>data.yearOfConstruction)
		{
			if(this.younger==null)
			{
				this.younger=obToAdd;
			}
			else
			{
				this.younger.addBuilding(b);
			}
		}
		else if(b.yearOfConstruction<data.yearOfConstruction)
		{
			if(this.older==null)
			{
				this.older=obToAdd;
			}
			else
			{
				this.older.addBuilding(b);
			}
		}
		else if(b.yearOfConstruction==data.yearOfConstruction)
		{
			if(b.height<=data.height)
			{
				if(this.same==null)
				{
					this.same=obToAdd;
				}
				else
				{
					this.same.addBuilding(b);
				}
			}
			else
			{
				Building temp1=new Building(data);
				Building temp2=this.same;
				Building temp3=this.older;
				Building temp4=this.younger;
				data=b;
				this.same=temp1;
				this.same.same=temp2;
				this.older=temp3;
				this.younger=temp4;
				temp1.older=null;
				temp1.younger=null;
			}
		}
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building addBuildings (Building b){
		// ADD YOUR CODE HERE
			this.addBuilding(b.data);
			if(b.older!=null)
			{
				this.addBuildings(b.older);
			}
			else if(b.same!=null)
			{
				this.addBuildings(b.same);
			}
			else if(b.younger!=null)
			{
				this.addBuildings(b.younger);
			}
		return this; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building removeBuilding (OneBuilding b){
		// ADD YOUR CODE HERE

		if(b.yearOfConstruction<this.data.yearOfConstruction)
		{
			if(this.older==null)
			{
				return this;
			}
			else
			{
				this.older=this.older.removeBuilding(b);
			}
		}
		else if(b.yearOfConstruction>this.data.yearOfConstruction)
		{
			if(this.younger==null)
			{
				return this;
			}
			else
			{
				this.younger=this.younger.removeBuilding(b);
			}
		}
		else if(b.yearOfConstruction==this.data.yearOfConstruction)
		{
			if(this.same!=null)
			{
				if(this.data.equals(b))
				{
					this.data=this.same.data;
					this.same=this.same.same;
					return this;
				}
				else
				{
					this.same=this.same.removeBuilding(b);
				}
			}
			else if(this.same==null)
			{
				if(this.data.equals(b))
				{
					if(this.older!=null)
					{
						this.data=this.older.data;
						this.older=this.older.older;
						this.younger=this.younger.younger;
						return this;
					}
					else if(this.younger!=null)
					{
						this.data=this.younger.data;
						this.younger=this.younger.younger;
						return this;
					}
					else
						return null;
				}
				else
				{
					return this;
				}
			}
		}
		return this;// DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int oldest(){
		// ADD YOUR CODE HERE
		Building old=this;
		while(old.older!=null)
		{
			old=old.older;
		}
		return old.data.yearOfConstruction; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int highest(){
		// ADD YOUR CODE HERE
		Building build=this;
		while(this.older!=null) 
		{
			build=build.older;
			if(this.data.height<this.older.data.height)
			{
				if(this.older.data.height>this.younger.data.height)
				{
					return this.older.data.height;
				}
				else
					return this.younger.data.height;
			}
			else if(this.data.height>=this.older.data.height)
			{
				if(this.data.height<this.younger.data.height)
				{
					return this.younger.data.height;
				}
				else
					return this.data.height;
			}
		}
		while(this.younger!=null) 
		{
			build=build.younger;
			if(this.data.height<this.older.data.height)
			{
				if(this.older.data.height>this.younger.data.height)
				{
					return this.older.data.height;
				}
				else
					return this.younger.data.height;
			}
			else if(this.data.height>=this.older.data.height)
			{
				if(this.data.height<this.younger.data.height)
				{
					return this.younger.data.height;
				}
				else
					return this.data.height;
			}
		}
		return this.data.height; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public OneBuilding highestFromYear (int year){
		// ADD YOUR CODE HERE
		if(this.data.yearOfConstruction<year)
		{
			if(this.younger==null)
			{
				return null;
			}
			else if(this.younger!=null)
			{
				return this.younger.highestFromYear(year);
			}
		}
		else if(this.data.yearOfConstruction>year)
		{
			if(this.older==null)
			{
				return null;
			}
			else if(this.older!=null)
			{
				return this.older.highestFromYear(year);
			}
		}
		else if(this.data.yearOfConstruction==year)
		{
			return this.data;
		}
		else return null;
		return new OneBuilding(""+this.data.name,this.data.yearOfConstruction,this.data.height,this.data.yearForRepair,this.data.costForRepair); // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int numberFromYears (int yearMin, int yearMax){
		// ADD YOUR CODE HERE
		int number=0;
		if(yearMin>yearMax)
			return 0;
		else 
		{
			if(this!=null&&this.data.yearOfConstruction>=yearMin&&this.data.yearOfConstruction<=yearMax)
			{
				number++;
			}
			if(this.same!=null&&this.same.data.yearOfConstruction>=yearMin&&this.same.data.yearOfConstruction<=yearMax)
			{
				number+=this.same.numberFromYears(yearMin, yearMax);
			}
			if(this.older!=null&&this.older.data.yearOfConstruction>=yearMin)
			{
				number+=this.older.numberFromYears(yearMin, yearMax);
			}
			if(this.older!=null&&this.older.data.yearOfConstruction<yearMin&&this.older.younger!=null)
			{
				number+=this.older.younger.numberFromYears(yearMin, yearMax);
			}
			if(this.younger!=null&&this.younger.data.yearOfConstruction<=yearMax)
			{
				number+=this.younger.numberFromYears(yearMin, yearMax);
			}
			if(this.younger!=null&&this.younger.data.yearOfConstruction<yearMin&&this.younger.older!=null)
			{
				number+=this.younger.older.numberFromYears(yearMin, yearMax);
			}
			return number;
		}
	}
	
	public int[] costPlanning (int nbYears){
		// ADD YOUR CODE HERE
		int []arr=new int[nbYears];
		for(int i=0;i<nbYears;i++)
		{
			arr[i]=cost(this,2018+i,0);
		}
		return arr; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	private int cost(Building Build,int year,int number)
	{
		if(Build !=null&&Build.data.yearForRepair==year)
		{
			number+=Build.data.costForRepair;
		}
		if(Build!=null)
		{
			number=cost(Build.older,year,number);
			number=cost(Build.same,year,number);
			number=cost(Build.younger,year,number);
		}
		return number;
	}
}

/**
 * @author Eugene
 * @author Liew Kuan Yung 
 */
public class MovementDiagonal implements MovementBehavior {

	@Override
	public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction) {
		
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();
    	if (tempx == tempy)
    	{
    		if (tempx > 0)//meaning the top right
    		{
    			if (end.getX() == start.getX() + 1)
    			{
    				return true; //making 1 tile step so no need check for obstacle
    			}
    			else
    			{
    				try {
    					for (int i = 1; i < tempx ; i++)
    					{
    						if (!board.getSpot(start.getX()+i,start.getY()+i).isEmpty())
    						{
    							i = 0;//stop the loop when it detects the first obstacle
    							return false;
    						}
    						else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
    						{
    							return true;
    						}
    					}
    				}catch(Exception e){
    					System.out.println("Exception: Diagonal");
    				}
    			}
    		}
    		else if (tempx < 0)//meaning the bottom left
    		{
    			if (end.getY() == start.getY() - 1)
    			{
    				return true; //making 1 tile step so no need check for obstacle
    			}
    			else
    			{
    				try {
    					for (int i = -1; i > tempx ; i--)
    					{
    						if (!board.getSpot(start.getX()+i,start.getY()+i).isEmpty())
    						{
    							i = 0;//stop the loop when it detects the first obstacle
    							return false;
    						}
    						else if (i == tempx + 1) //if the end of the loop means no obstacle so return true
    						{
    							return true;
    						}
    					}
    				}catch(Exception e){
    					System.out.println("Exception: Diagonal");
    				}
    			}
    		}
    	}
    	else if (tempx == -tempy)//meaning the bottom right
    	{
    		if(tempy < 0) {
	    		if (end.getX() == start.getX() + 1)
	    		{
	    			return true; //making 1 tile step so no need check for obstacle
	    		}
	    		else
	    		{
	    			try {
	    				for (int i = 1; i < tempx ; i++)
	    				{
	    					if (!board.getSpot(start.getX()+i,start.getY()-i).isEmpty())
	    					{
	    						i = 0;//stop the loop when it detects the first obstacle
	    						return false;
	    					}
	    					else if (i == tempx - 1) //if the end of the loop means no obstacle so return true
	    					{
	    						return true;
	    					}
	    				}
	    			}catch(Exception e){
	    				System.out.println("Exception: Diagonal");
	    			}
	    		}
    		} 
    		else if (tempy > 0) {//meaning the top left
	    		if (end.getY() == start.getY() + 1)
	    		{
	    			return true; //making 1 tile step so no need check for obstacle
	    		}
	    		else
	    		{
	    			try {
	    				for (int i = 1; i < tempy ; i++)
	    				{
	    					if (!board.getSpot(start.getX()-i,start.getY()+i).isEmpty())
	    					{
	    						i = 0;//stop the loop when it detects the first obstacle
	    						return false;
	    					}
	    					else if (i == tempy - 1) //if the end of the loop means no obstacle so return true
	    					{
	    						return true;
	    					}
	    				}
	    			}catch(Exception e){
	    				System.out.println("Exception: Diagonal");
	    			}
	    		}
    		}
    	}
    	else //if it is not the movement rule of Triangle
    	{
    		return false;
    		//pop up display "Illegal movement"
    	}
    	return false;
	}

}

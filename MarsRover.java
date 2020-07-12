/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsrover;

/**
 *
 * @author Hariesha95
 */

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hariesha95
 */
public class MarsRover
{
    int x = 0, y = 0;
    int x1 = 0,y1 = 0;
    char dir;
    int grid[][];
    
    public void Position(int posx,int posy,char Roverdir)
    {
        this.x = posx;
        this.y = posy;
        this.dir = Roverdir;
    }
    
    public  void Grid(int c1,int c2)
    {   
        this.x1 = c1+1;
        this.y1 = c2+1;
        grid = new int[x1][y1];
        for (int i = 0; i < x1 ; i++)
            for(int j = 0; j < y1; j++)
                this.grid[i][j] = 1;
        
    }
    
    public void Obstacles(int ob1,int ob2)
    {   
        for (int i = 0; i < x1 ; i++)
            for(int j = 0; j < y1; j++){
                if(i==ob1 && j==ob2)
                    this.grid[i][j] = 2;
            }
    }
    
    public void RotateLeft()
    {
        switch (dir) { 
        case 'N': dir = 'W'; break;
        case 'W': dir = 'S'; break;
        case 'S': dir = 'E'; break;
        case 'E': dir = 'N'; break;
        }
    }

    public void RotateRight()
    {
        switch (dir) { 
        case 'N': dir = 'E'; break;
        case 'W': dir = 'N'; break;
        case 'S': dir = 'W'; break;
        case 'E': dir = 'S'; break;
        }
    }
    
    public void MovePosition()
    {
        switch (dir) 
        { 
        case 'N':   if(grid[x][y+1] == 2 || y+1>y1)
                    {
                        RotateLeft();
                        MovePosition();
                    }
                    else    
                        y++; 
                    break;
        case 'W':   if( x-1<0 || grid[x-1][y] == 2 )
                    {
                        RotateLeft();
                        MovePosition();
                    }
                    else 
                        x--; 
                    break;

        case 'S':   if(y-1<0 || grid[x][y-1] == 2  )
                    {
                        RotateLeft();
                        MovePosition();
                    }
                    else 
                        y--; 
                    break;
        case 'E':   if(x+1>x1 || grid[x+1][y] == 2)
                    {
                         RotateLeft();
                         MovePosition();
                    }
                    else
                        x++; 
                    break;
        }
        
    }
    
    public void DisplayPosition()
    {
        System.out.print(x+" "+y+" "+dir+"\n");
    }
    
    public static void main(String []args)
    {
        MarsRover r = new MarsRover();
        Scanner s = new Scanner(System.in);
        int rx1,ry1,x1,y1,obs,ob1,ob2; 
        char orient1;
        String RoverMovement1; 
        
        System.out.print("Enter Upper Right Cordinates: ");
        x1 = s.nextInt();
        y1 = s.nextInt();
            r.Grid(x1,y1);
            
        System.out.print("Enter Number of Obstacles: ");
        obs = s.nextInt();
        System.out.print("Enter the Cordinates of the Obstacles :");
        
        for(int n = 0; n < obs ; n++)
        {
            ob1 = s.nextInt();
            ob2 = s.nextInt();
            r.Obstacles(ob1, ob2);
        }
     
        System.out.print("Enter the Rover Position: ");
        rx1 = s.nextInt();
        ry1 = s.nextInt();
        orient1 = s.next().toUpperCase().charAt(0);
        r.Position(rx1, ry1 , orient1);
        
        System.out.print("Enter the RoverPath: ");
        RoverMovement1 = s.next();
        char[] RMovement1 = RoverMovement1.toUpperCase().toCharArray();
        
        for(int i=0 ; i < RoverMovement1.length() ; i++)
        {
            if(RMovement1[i] == 'L')
            {
                r.RotateLeft();
                System.out.print("Right Turn -->");
                r.DisplayPosition();
            }
            else if(RMovement1[i] == 'R')
            {
                r.RotateRight();
                System.out.print("Right Turn -->");
                r.DisplayPosition();
            }
            else if(RMovement1[i] == 'M')
            {
                r.MovePosition();
                System.out.print("Move Forward -->");
                r.DisplayPosition();
            }
            
        }
        
        System.out.print("Final Rover Position -->");r.DisplayPosition();
    

    }
    
    
   
  
}

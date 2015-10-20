
public class Problem223_Rectangle_Area {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        tube T1 = trans(A,B,C,D);
        tube T2 = trans(E,F,G,H);
        A = T1.A; B = T1.B; C = T1.C; D=T1.D;
        E=T2.A; F=T2.B; G = T2.C; H = T2.D;
        int area1 = area(A, B, C, D);
        int area2 = area(E, F, G, H);
        int overlap = 0;
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int bottom = Math.max(B,F);
        int top = Math.min(D,H);
        if(right > left && top > bottom)
            overlap = (right-left)*(top-bottom);
        return area1 + area2 - overlap;
        
    }
    public int area(int A, int B, int C, int D){
        return (C-A)*(D-B);
    }
    class tube{
        int A,B,C,D;
        tube(int a,int b,int c,int d){
            A=a;B=b;
            C=c;D=d;
        }
    }
    
    public tube trans(int A, int B, int C, int D){
        int newA = Math.min(A,C);
        int newC = Math.max(A,C);
        int newB = Math.min(B,D);
        int newD = Math.max(B,D);
        return new tube(newA, newB, newC, newD);
    }
}

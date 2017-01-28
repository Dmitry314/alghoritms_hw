#include<iostream>


int binpow(int a, int n)
{
    if(n ==0 )
    {
        return 1;
    }

    if( n % 2 ==0)
    {
        int res = binpow(a, n/2);
        return res * res;

    }

    if( n%2 ==1 )
    {
        int res = binpow(a , n-1);
        return a * res;

    }


}

int binpow_mod_m(int a, int n, int m)
{
    if(n ==0 )
    {
        return 1;
    }

    if( n % 2 ==0)
    {
        int res = binpow(a, n/2) % m;
        return res * res  % m;

    }

    if( n%2 ==1 )
    {
        int res = binpow(a , n-1) %m;
        return a * res % m;

    }


}





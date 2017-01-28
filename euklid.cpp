#include<iostream>

using namespace std;

int gcd(int a, int b)
{
    if(a > b)
    {
        if(b == 0)
        {

            return a;

        }
        else
        {
            return gcd(b, a%b);


        }

    }

    else
    {
        if(a ==0)
        {
            return b;

        }

        else
        {
            return gcd(a, b%a);

        }


    }





}




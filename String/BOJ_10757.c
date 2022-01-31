#include <stdio.h>
#include <string.h>

int main()
{
    int la, lb, ls, i, sum;
    char ta[10001];
    char tb[10001];
    int a[10001] = { 0 };
    int b[10001] = { 0 };
    int s[10001] = { 0 };

    scanf("%s%s", ta, tb);

    la = strlen(ta);
    lb = strlen(tb);
    ls = la > lb ? la : lb;

    for (i = 0; i < la; i++)
    {
        a[i] = ta[la - i - 1] - '0';
    }

    for (i = 0; i < lb; i++)
    {
        b[i] = tb[lb - i - 1] - '0';
    }

    for (i = 0; i < ls - 1; i++)
    {
        sum = s[i] + a[i] + b[i];
        s[i] = sum % 10;
        s[i + 1] += sum / 10;
    }
    s[ls - 1] += a[ls - 1] + b[ls - 1];

    for (i = ls - 1; i >= 0; i--)
    {
        printf("%d", s[i]);
    }
}
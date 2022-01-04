#include <assert.h>

enum { MAX_NUMS = 8 };

int s_nums[MAX_NUMS];
size_t s_num_count = 0;

void push(int n);
int is_empty(void);
int pop(void);

int main(void)
{
    int num;

    push(88);
    push(44);
    push(22);

    num = pop();
    num = pop();

    return 0;
}

void push(int n)
{
    assert(s_num_count < MAX_NUMS);
    s_nums[s_num_count++] = n;
}

int is_empty(void)
{
    return (s_num_count == 0);
}

int pop(void)
{
    assert(is_empty == 0); // 0 == false

    return s_nums[--s_num_count];
}
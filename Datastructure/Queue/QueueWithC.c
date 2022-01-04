#include <assert.h>

enum { MAX_NUMS = 8 };

int s_nums[MAX_NUMS];
size_t s_front = 0;
size_t s_back = 0;
size_t s_num_count = 0;

void enqueue(int n);
int is_empty(void);
int dequeue(void);

int main(void)
{
    int item;

    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    enqueue(50);
    enqueue(60);
    enqueue(70);
    enqueue(80);

    // s_nums = { 10, 20, 30, 40, 50, 60, 70, 80};
    item = dequeue(); // item: 10

    return 0;
}

void enqueue(int n)
{
    assert(s_num_count < MAX_NUMS);

    s_nums[s_back] = n;

    s_back = (s_back + 1) % MAX_NUMS;

    ++s_num_count;
}

int is_empty(void)
{
    return (s_num_count == 0);
}

int dequeue(void)
{
    int ret;

    assert(is_empty() == 0);

    ret = s_nums[s_front];

    --s_num_count;
    s_front = (s_front + 1) % MAX_NUMS;

    return ret;
}
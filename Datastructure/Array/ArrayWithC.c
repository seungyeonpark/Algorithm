#include <assert.h>

enum { MAX_NUMS = 8 };
enum { INVALID_INDEX = -1 };

int s_nums[MAX_NUMS];
size_t s_num_count = 0;

void insert_at(size_t index, int n);
void remove_at(size_t index);
size_t find_index(int n);

int main(void)
{
    size_t index; 

    insert_at(0, 1);
    insert_at(0, 2);
    insert_at(0, 3);
    insert_at(0, 4);
    insert_at(0, 5);
    insert_at(0, 6);
    insert_at(0, 7);
    insert_at(7, 8);

    // s_nums[] = { 7, 6, 5, 4, 3, 2, 8 }
    remove_at(7);
    remove_at(0);
    remove_at(0);

    index = find_index(20);

    return 0;
}

void insert_at(size_t index, int n)
{
    size_t i;

    assert(index <= s_num_count);
    assert(s_num_count < MAX_NUMS);

    for (i = s_num_count; i > index; i--) {
        s_nums[i] = s_nums[i - 1];
    }

    s_nums[index] = n;
    ++s_num_count;
}

void remove_at(size_t index)
{
    size_t i;

    assert(index < s_num_count);

    --s_num_count;
    for (i = index; i < s_num_count; i++) {
        s_nums[i] = s_nums[i + 1];
    }
}

size_t find_index(int n)
{
    size_t i;

    for (i = 0; i < s_num_count; i++) {
        if (s_nums[i] == n) {
            return 1;
        }
    }

    return INVALID_INDEX;
}
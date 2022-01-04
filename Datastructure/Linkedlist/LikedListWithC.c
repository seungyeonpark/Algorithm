#include <stdlib.h>

typedef struct node {
    int value;
    struct node* next;
} node_t;

void insert_front(node_t** phead, int n);
void insert_sorted(node_t** phead, int n);
void remove(node_t** phead, int n);
void print_node(const node_t* head);
void destroy(node_t* head);

int main(void)
{
    node_t* head = NULL;

    insert_front(&head, 3);
    insert_front(&head, 5);
    insert_front(&head, 2);
    insert_front(&head, 0);

    insert_sorted(&head, 1);
    insert_sorted(&head, 4);
    insert_sorted(&head, 2);
    insert_sorted(&head, 6);

    remove(&head, 2);
    remove(&head, 5);

    destroy(head);
    head = NULL;
}

void insert_front(node_t** phead, int n)
{
    node_t* new_node;

    new_node = malloc(sizeof(node_t));
    new_node->value = n;

    new_node->next = *phead;
    *phead = new_node;
}

void insert_sorted(node_t** phead, int n)
{
    node_t** pp;
    node_t* new_node;

    new_node = malloc(sizeof(node_t));
    new_node->value = n;

    pp = phead;
    while (*pp != NULL) {
        if ((*pp)->value >= n) {
            break;
        }

        pp = &(*pp)->next;
    }
    
    new_node->next = *pp;
    *pp = new_node;
}

void remove(node_t** phead, int n)
{
    node_t** pp;

    pp = phead;
    while (*pp != NULL) {
        if ((*pp)->value == n) {
            node_t* tmp = *pp;
            *pp = (*pp)->next;
            free(tmp);
            break;
        }

        pp = &(*pp)->next;
    }
}

void print_node(node_t* head)
{
    node_t* p;

    p = head;
    while (p != NULL) {
        // print
        p = p->next;
    }
}

void destroy(node_t* head)
{
    node_t* p = head;

    while (p != NULL) {
        node_t* next = p->next;
        free(p);
        p = next;
    }
}
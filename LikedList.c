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

    // 함수 내에서 node_t*형의 값을 바꿔야 함으로 node_t*의 주소(이중 포인터) 전달해야 함
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

    // node_t의 참조만 필요하므로 node_t의 주소(단일 포인터) 전달하면 됨
    print_node(head);

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
        // 해제할 노드에 있는 다음 노드 주소 저장
        node_t* next = p->next;
        // 노드 해제
        free(p);
        // 다음 노드를 가리킴
        p = next;
    }
}
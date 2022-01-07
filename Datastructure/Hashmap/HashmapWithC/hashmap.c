#include <stdlib.h>
#include <string.h>
#include "hashmap.h"

hashmap_t* init_hashmap_malloc(size_t length, size_t (*p_hash_func)(const char* key))
{
    size_t i;
    hashmap_t* hashmap;

    // hashmap 구조체 메모리 동적 할당
    hashmap = malloc(sizeof(hashmap_t));

    // 해쉬 함수 초기화
    hashmap->hash_func = p_hash_func;
    // plist 메모리 동적 할당
    hashmap->plist = malloc(length * sizeof(node_t));
    for (i = 0; i < length; i++) {
        *((hashmap->plist) + i) = NULL;
    }
    // length 초기화
    hashmap->length = length;

    return hashmap;
}

int add_key(hashmap_t* hashmap, const char* key, const int value)
{
    size_t i;
    size_t hash_id;
    size_t bucket_size;
    size_t (*hash_func)(const char* key);
    node_t* p_plist;
    node_t* p_next;

    hash_func = hashmap->hash_func;
    hash_id = hash_func(key);

    bucket_size = hashmap->length;
    i = hash_id % bucket_size;

    if (*((hashmap->plist) + i) == NULL) {
        *((hashmap->plist) + i) = malloc(sizeof(node_t));
        p_plist = *((hashmap->plist) + i);
        p_plist->key = malloc(strlen(key) + 1);
        strcpy(p_plist->key, key);
        p_plist->value = value;
        p_plist->next = NULL;

        return TRUE;
    }

    p_next = *((hashmap->plist) + i);
    while (TRUE) {
        if (strcmp((p_next->key), key) == 0) {
            return FALSE;
        } else if (p_next->next == NULL) {
            // 새 키-값을 삽입
            p_next->next = malloc(sizeof(node_t));
            p_next->next->key = malloc(strlen(key) + 1);
            strcpy(p_next->next->key, key);
            p_next->next->value = value;
            p_next->next->next = NULL;

            return TRUE;
        }

        p_next = p_next->next;
    }

    return FALSE;
}

int get_value(const hashmap_t* hashmap, const char* key)
{
    size_t i;
    size_t hash_id;
    size_t (*hash_func)(const char* key);
    node_t* p_node;

    hash_func = hashmap->hash_func;
    hash_id = hash_func(key);
    i = hash_id % (hashmap->length);

    p_node = *((hashmap->plist) + i);

    if (p_node == NULL) {
        return -1;
    }

    while (TRUE) {
        if (strcmp(p_node->key, key) == 0) {
            return p_node->value;
        }

        if (p_node->next == NULL) {
            return -1;
        }

        p_node = p_node->next;
    }
}

int update_value(hashmap_t* hashmap, const char* key, int value)
{
    size_t i;
    size_t hash_id;
    size_t (*hash_func)(const char* key);
    node_t* p_node;

    if (get_value(hashmap, key) == -1) {
        return FALSE;
    }

    hash_func = hashmap->hash_func;
    hash_id = hash_func(key);
    i = hash_id % (hashmap->length);

    p_node = *((hashmap->plist) + i);

    while (TRUE) {
        if (strcmp(p_node->key, key) == 0) {
            p_node->value = value;
            return TRUE;
        }

        p_node = p_node->next;
    }
}

int remove_key(hashmap_t* hashmap, const char* key)
{
    size_t i;
    size_t hash_id;
    size_t (*hash_func)(const char* key);
    node_t** pp_node;
    node_t* tmp;

    if (get_value(hashmap, key) == -1) {
        return FALSE;
    }

    hash_func = hashmap->hash_func;
    hash_id = hash_func(key);
    i = hash_id % (hashmap->length);

    pp_node = (hashmap->plist) + i;

    while (*pp_node != NULL) {
        if (strcmp((*pp_node)->key, key) == 0) {
            tmp = *pp_node;
            *pp_node = (*pp_node)->next;
            free(tmp->key);
            free(tmp);
            return TRUE;
        }

        pp_node = &(*pp_node)->next;
    }

    return FALSE;
}

void destroy(hashmap_t* hashmap)
{
    size_t i;
    size_t length = hashmap->length;

    for (i = 0; i < length; i++) {
        if (*((hashmap->plist) + i) != NULL) {
            free_node_recur(*((hashmap->plist) + i));
        }
    }
    free(hashmap->plist);
    free(hashmap);
}

int free_node_recur(node_t* p_node_t)
{
    if ((p_node_t->next) != NULL) {
        free_node_recur(p_node_t->next);
    }

    free(p_node_t->key);
    free(p_node_t);

    return TRUE;
}
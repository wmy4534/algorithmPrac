#include <stdio.h>

int main(int argc, const char * argv[]) {
    int chess[] = {1, 1, 2, 2, 2, 8};
    int suggest[6];
    for (int i = 0; i < 6; i++) {
        scanf("%d", &suggest[i]);
    }
    
    for (int i = 0; i < 6; i++) {
        printf("%d ", chess[i] - suggest[i]);
    }
    
    return 0;
}


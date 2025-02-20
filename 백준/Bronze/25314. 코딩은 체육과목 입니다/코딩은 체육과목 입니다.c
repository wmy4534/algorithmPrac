#include <stdio.h>

int main(int argc, const char * argv[]) {
    int N = 0;
    scanf("%d", &N);

    for (int i = 0; i < N/4; i++) {
        printf("long ");
    }
    printf("int\n");
    
    return 0;
}

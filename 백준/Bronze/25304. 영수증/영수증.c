#include <stdio.h>

int main(int argc, const char * argv[]) {
    int X = 0, N = 0;
    scanf("%d", &X);
    scanf("%d", &N);
    
    int sum = 0;
    for (int i = 0; i < N; i++) {
        int price, count;
        scanf("%d %d", &price, &count);
        sum += price * count;
    }
    
    if (sum == X) {
        printf("Yes\n");
    } else {
        printf("No\n");
    }
    
    return 0;
}

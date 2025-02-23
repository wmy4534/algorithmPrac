#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

static int N = 0, K = 0;

int main(int argc, const char * argv[]) {
    scanf("%d %d", &N, &K);
    int height[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &height[i]);
    }
    int min = 123456789;
    for (int s = 0; s < N; s++) { // start
        int base = height[s];
        int count = 0;
        for (int b = s - 1; b >= 0; b--) { // before
            base -= K;
            if (height[b] == base)
                continue;
            count++;
        }
        if (base < 1)
            continue;
        
        base = height[s];
        for (int a = s + 1; a < N; a++) { // after
            base += K;
            if (height[a] == base)
                continue;
            count++;
        }
        
        if (count < min) {
            min = count;
        }
    }
    printf("%d\n", min);
    return 0;
}

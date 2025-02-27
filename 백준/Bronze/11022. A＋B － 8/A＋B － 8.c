#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int T, a, b;
    scanf("%d", &T);
    for (int t = 1; t <= T; t++) {
        scanf("%d %d", &a, &b);
        printf("Case #%d: %d + %d = %d\n", t, a, b, a + b);
    }
}

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int T = 0;
    scanf("%d", &T);
    for (int t = 1; t <= T; t++) {
        int num1, num2;
        scanf("%d %d", &num1, &num2);
        printf("Case #%d: %d\n", t, num1 + num2);
    }
    return 0;
}

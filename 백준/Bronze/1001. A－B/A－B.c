#include <stdio.h>

int main(int argc, const char * argv[]) {
    int num1 = 0, num2 = 0;
    for (int i = 0; i < 2; i++) {
        if (num1 > 0) {
            scanf("%d", &num2);
        } else {
            scanf("%d", &num1);
        }
    }
    printf("%d", num1 - num2);
    return 0;
}

#include <stdio.h>

int main(int argc, const char * argv[]) {
    int sum = 0, num;
    for (int i = 0; i < 2; i++) {
        scanf("%d", &num);
        sum += num;
    }
    printf("%d", sum);
    return 0;
}

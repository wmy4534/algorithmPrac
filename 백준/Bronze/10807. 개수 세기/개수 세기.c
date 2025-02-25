#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int N = 0, num = 0;
    scanf("%d", &N);
    int arr[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }
    int v = 0, cnt = 0;
    scanf("%d", &v);
    for (int i = 0; i < N; i++) {
        if (arr[i] == v)
            cnt++;
    }
    printf("%d\n", cnt);
}

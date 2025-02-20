#include <stdio.h>

int main(int argc, const char * argv[]) {
    int h = 0, m = 0, time = 0;
    scanf("%d", &h);
    scanf("%d", &m);
    scanf("%d", &time);
    m += time;
    h += m / 60;
    m %= 60;
    h %= 24;
    
    printf("%d %d", h, m);
    
    return 0;
}

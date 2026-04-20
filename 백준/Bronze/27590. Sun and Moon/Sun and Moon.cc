#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>


void solve() {

    int ds, ys, dm, ym;
    std::cin >> ds >> ys;
    std::cin >> dm >> ym;

    for (int t = 1; t <= 5000; t++) {
        if ((ds + t) % ys == 0 && (dm + t) % ym == 0) {
            std::cout << t;
            break;
        }
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
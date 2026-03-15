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

    int n;
    std::cin >> n;

    for (int i = 1; i <= n; i++) {
        int a, b, res;
        char op, eq;
        std::cin >> a >> op >> b >> eq >> res;

        bool correct = false;
        if (op == '+') {
            correct = (a + b == res);
        }
        else {
            correct = (a - b == res);
        }

        std::cout << "Case " << i << ": " << ((correct) ? "YES" : "NO") << "\n";
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
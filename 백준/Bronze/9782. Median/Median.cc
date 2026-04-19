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

    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n;
    int caseNum = 1;

    while (std::cin >> n && n != 0) {
        std::vector<int> v(n);

        for (int i = 0; i < n; i++) {
            std::cin >> v[i];
        }

        double median;

        if (n % 2 == 1) {
            median = v[n / 2];
        }
        else {
            median = (v[n / 2 - 1] + v[n / 2]) / 2.0;
        }

        std::cout << "Case " << caseNum++ << ": ";
        std::cout << std::fixed << std::setprecision(1) << median << '\n';
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
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

    int t;
    std::cin >> t;

    while (t--) {
        int a, b, c;
		std::cin >> a >> b >> c;

        std::cout << "Data set: " << a << " " << b << " " << c << "\n";

        while (c--) {
            if (a > b) {
				a /= 2;
            } else {
				b /= 2;
            }
        }
		int max_value = std::max(a, b);
		int min_value = std::min(a, b);
		std::cout << max_value << " " << min_value << "\n\n";
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
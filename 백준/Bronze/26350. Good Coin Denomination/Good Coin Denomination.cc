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
        int n;
		std::cin >> n;

		bool flag = true;

        n--;
        int prev;
		std::cin >> prev;

		std::cout << "Denominations: " << prev << " ";

        while (n--) {
            int now;
			std::cin >> now;
			std::cout << now << " ";
            if (prev << 1 > now) {
				flag = false;
            }
			prev = now;
        }

		std::cout << "\n" << (flag ? "Good" : "Bad") << " coin denominations!\n\n";

    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
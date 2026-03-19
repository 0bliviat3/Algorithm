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

        std::string s;
		std::cin >> s;


        s.erase(s.begin() + n - 1);
		std::cout << s << "\n";
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}
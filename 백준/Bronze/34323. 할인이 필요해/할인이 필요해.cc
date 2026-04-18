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

    long long N, M, S;
    std::cin >> N >> M >> S;

    long long cost_bundle = M * S;

    long long temp = (M + 1) * S * (100 - N);
    long long cost_percent = (long long)(temp / 100);

    std::cout << std::min(cost_bundle, cost_percent);

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}